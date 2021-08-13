package com.zz.example.nio.client;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author sp0038
 * @date 2021/8/12
 */
public class OkHttpDemo {
    public static void main(String[] args) throws IOException {
        String url = "http://127.0.0.1:8081";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        assert response.body() != null;
        System.out.println(response.body().string());
    }
}
