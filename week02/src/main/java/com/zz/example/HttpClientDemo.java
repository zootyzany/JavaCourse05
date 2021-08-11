package com.zz.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author sp0038
 * @date 2021/8/11
 */
public class HttpClientDemo {
    public static void main(String[] args) {
        String body = doGet("http://127.0.0.1:8081", null);
        System.out.println(body);
    }

    public static String doGet(String url, Map<String, String> params) {

        //获取httpclient客户端
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;

        try {
            URIBuilder builder = new URIBuilder(url);
            if (null != params) {
                for (String key : params.keySet()) {
                    builder.setParameter(key, params.get(key));
                }
            }
            HttpGet get = new HttpGet(builder.build());
            response = httpclient.execute(get);
            System.out.println(response.getStatusLine());

            if (200 == response.getStatusLine().getStatusCode()) {
                HttpEntity entity = response.getEntity();
                resultString = EntityUtils.toString(entity, "utf-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpclient) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }
}