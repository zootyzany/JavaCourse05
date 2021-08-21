package io.github.kimmking.gateway.router;

import java.util.List;

/**
 * @author zhouzeng
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

    // Load Balance
    // Random
    // RoundRibbon 
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}
