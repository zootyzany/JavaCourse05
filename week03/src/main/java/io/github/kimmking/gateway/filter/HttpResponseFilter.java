package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author zhouzeng
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}
