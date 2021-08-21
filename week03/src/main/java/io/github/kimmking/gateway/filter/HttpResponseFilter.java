package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author zhouzeng
 */
public interface HttpResponseFilter {

    /**
     * response的过滤器
     *
     * @param response response请求
     */
    void filter(FullHttpResponse response);

}
