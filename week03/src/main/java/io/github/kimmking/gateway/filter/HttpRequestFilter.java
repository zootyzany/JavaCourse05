package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author zhouzeng
 */
public interface HttpRequestFilter {

    /**
     * request的过滤器
     *
     * @param fullRequest request请求
     * @param ctx         ChannelHandlerContext
     */
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);

}
