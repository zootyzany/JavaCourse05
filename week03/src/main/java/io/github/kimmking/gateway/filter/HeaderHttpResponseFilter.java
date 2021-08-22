package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author zhouzeng
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        System.out.println("打印请求处理后的时间:" + System.currentTimeMillis());
    }
}
