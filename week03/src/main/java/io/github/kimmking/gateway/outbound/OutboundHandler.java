package io.github.kimmking.gateway.outbound;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author sp0038
 * @date 2021/8/19
 */
public interface OutboundHandler {

    /**
     * 处理请求
     *
     * @param fullRequest 请求
     * @param ctx         channelHandlerContext
     * @param filter      过滤器
     */
    void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx, HttpRequestFilter filter);
}