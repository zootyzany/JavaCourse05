package io.github.kimmking.gateway.outbound.httpclient4;


import io.github.kimmking.gateway.filter.HeaderHttpResponseFilter;
import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.github.kimmking.gateway.filter.HttpResponseFilter;
import io.github.kimmking.gateway.outbound.OutboundHandler;
import io.github.kimmking.gateway.router.HttpEndpointRouter;
import io.github.kimmking.gateway.router.RandomHttpEndpointRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author zhouzeng
 */
public class HttpOutboundHandler implements OutboundHandler {
    private static Logger logger = LoggerFactory.getLogger(HttpOutboundHandler.class);

    HttpResponseFilter filter = new HeaderHttpResponseFilter();
    HttpEndpointRouter router = new RandomHttpEndpointRouter();

    private CloseableHttpAsyncClient httpclient;
    private ExecutorService proxyService;
    private List<String> backendUrls;

    public HttpOutboundHandler(List<String> backEnds) {
        this.backendUrls = backEnds.stream().map(this::formatUrl).collect(Collectors.toList());

        int cores = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 1000;
        int queueSize = 2048;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        proxyService = new ThreadPoolExecutor(cores, cores,
                keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
                new NamedThreadFactory("proxyService"), handler);

        IOReactorConfig ioConfig = IOReactorConfig.custom()
                .setConnectTimeout(1000)
                .setSoTimeout(1000)
                .setIoThreadCount(cores)
                .setRcvBufSize(32 * 1024)
                .build();

        httpclient = HttpAsyncClients.custom().setMaxConnTotal(40)
                .setMaxConnPerRoute(8)
                .setDefaultIOReactorConfig(ioConfig)
                .setKeepAliveStrategy((response, context) -> 6000)
                .build();
        httpclient.start();
    }

    private String formatUrl(String backend) {
        return backend.endsWith("/") ? backend.substring(0, backend.length() - 1) : backend;
    }

    @Override
    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, HttpRequestFilter filter) {
        filter.filter(fullRequest, ctx);

        String backendUrl = router.route(this.backendUrls);
        final String url = backendUrl + fullRequest.uri();

        HttpUriRequest request = buildRequest(url, fullRequest);
        proxyService.submit(() -> execute(fullRequest, request, ctx));

        /*if (HttpMethod.GET.equals(method)) {
            proxyService.submit(() -> fetchGet(fullRequest, ctx, url));
        } else if (HttpMethod.POST.equals(method)) {
            String str = fullRequest.content().toString(Charsets.toCharset(CharEncoding.UTF_8));
            if (!StringUtil.isNullOrEmpty(str)) {
                HttpPost post = new HttpPost(url);
                post.setEntity(new StringEntity(str, "UTF-8"));
                proxyService.submit(() -> execute(fullRequest, post, ctx));
            }
        } else {
            logger.error("目前该类型方法不支持");
        }*/
    }

    /*private void fetchGet(final FullHttpRequest inbound, final ChannelHandlerContext ctx, final String url) {
        final HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);

        httpclient.execute(httpGet, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(final HttpResponse endpointResponse) {
                try {
                    handleResponse(inbound, ctx, endpointResponse);
                } catch (Exception e) {
                    logger.error("Httpclient complete failed. cause:[]", e);
                }
            }

            @Override
            public void failed(final Exception ex) {
                httpGet.abort();
                logger.error("Httpclient execute failed. cause:[]", ex);
            }

            @Override
            public void cancelled() {
                httpGet.abort();
            }
        });
    }*/

    public HttpEntityEnclosingRequestBase buildRequest(final String url, final FullHttpRequest fullRequest) {
        HttpEntityEnclosingRequestBase request = new HttpEntityEnclosingRequestBase() {
            @Override
            public String getMethod() {
                return fullRequest.method().name();
            }
        };
        request.setURI(URI.create(url));
        String str = fullRequest.content().toString(Charsets.toCharset(CharEncoding.UTF_8));
        if (!StringUtil.isNullOrEmpty(str)) {
            request.setEntity(new StringEntity(str, "utf-8"));
        }
        return request;
    }
    
    private void execute(final FullHttpRequest inbound, final HttpUriRequest request, final ChannelHandlerContext ctx) {
        request.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        request.setHeader(HTTP.CONTENT_ENCODING, "application/json");

        httpclient.execute(request, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(final HttpResponse endpointResponse) {
                try {
                    handleResponse(inbound, ctx, endpointResponse);
                } catch (Exception e) {
                    logger.error("Httpclient complete failed. cause:[]", e);
                }
            }

            @Override
            public void failed(final Exception ex) {
                request.abort();
                logger.error("Httpclient execute failed. cause:[]", ex);
            }

            @Override
            public void cancelled() {
                request.abort();
            }
        });
    }

    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final HttpResponse endpointResponse) {
        FullHttpResponse response = null;
        try {
            byte[] body = EntityUtils.toByteArray(endpointResponse.getEntity());
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", Integer.parseInt(endpointResponse.getFirstHeader("Content-Length").getValue()));
            filter.filter(response);
        } catch (Exception e) {
            logger.error("Invoke handleResponse failed. cause:[]", e);
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(response);
                }
            }
            ctx.flush();
        }

    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
