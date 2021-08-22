package io.github.kimmking.gateway.inbound;

import io.github.kimmking.gateway.NettyServerApplication;
import io.github.kimmking.gateway.filter.HeaderHttpRequestFilter;
import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.github.kimmking.gateway.outbound.OutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @author zhouzeng
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);

    private OutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();

    public HttpInboundHandler(List<String> proxyServer) {
        // 模拟Spring的依赖注入
        OutboundHandler handler = (OutboundHandler) NettyServerApplication.CONTEXT.get("handler_type");
        this.handler = handler;
    }

    public HttpInboundHandler() {
        // 模拟Spring的依赖注入
        OutboundHandler handler = (OutboundHandler) NettyServerApplication.CONTEXT.get("handler_type");
        this.handler = handler;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx, filter);
        } catch (Exception e) {
            logger.warn("Failed to read channel msg, cause: []", e);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
