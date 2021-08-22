package io.github.kimmking.gateway;


import io.github.kimmking.gateway.inbound.HttpInboundServer;
import io.github.kimmking.gateway.outbound.OutboundHandler;
import io.github.kimmking.gateway.outbound.httpclient4.HttpOutboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouzeng
 */
public class NettyServerApplication {
    private static Logger logger = LoggerFactory.getLogger(NettyServerApplication.class);
    /**
     * 模拟Spring 容器
     */
    public static Map<String, Object> CONTEXT = new HashMap<>();

    /**
     * 这是之前的单个后端url的例子
     * String proxyServer = System.getProperty("proxyServer","http://localhost:8088");
     * http://localhost:8888/api/hello  ==> gateway API
     * http://localhost:8088/api/hello  ==> backend service
     * java -Xmx512m gateway-server-0.0.1-SNAPSHOT.jar  #作为后端服务
     */

    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort", "8888");
        String proxyServers = System.getProperty("proxyServers", "http://localhost:8801,http://localhost:8802");

        int port = Integer.parseInt(proxyPort);
        logger.info("NIOGateway 3.0.0 starting...");
        List<String> proxyServerList = Arrays.asList(proxyServers.split(","));
        OutboundHandler handler = new HttpOutboundHandler(proxyServerList);
        CONTEXT.put("handler_type", handler);

        HttpInboundServer server = new HttpInboundServer(port, proxyServerList);
        logger.info("NIOGateway 3.0.0 started at http://localhost: {} for server:{}", port, server.toString());
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
