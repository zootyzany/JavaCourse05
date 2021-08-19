//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.zz.example;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;

public class HttpsApiClientpsa_o2o_prod extends ApacheHttpClient {
    public final static String HOST = "gw.o2o.mpsa.cn";
    static HttpsApiClientpsa_o2o_prod instance = new HttpsApiClientpsa_o2o_prod();

    public static HttpsApiClientpsa_o2o_prod getInstance() {
        return instance;
    }

    @Override
    public void init(HttpClientBuilderParams httpClientBuilderParams) {
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }


    public void DCS_同步服务包使用情况(ApiCallback callback) {
        String path = "/api/v1/servicepackage/syncUsage";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse DCS_同步服务包使用情况SyncMode() {
        String path = "/api/v1/servicepackage/syncUsage";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);


        return sendSyncRequest(request);
    }

    public void O2O_PROD_aso_查询维保记录_anlian(ApiCallback callback) {
        String path = "/api/v1/external/repair/record";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse O2O_PROD_aso_查询维保记录_anlianSyncMode() {
        String path = "/api/v1/external/repair/record";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);


        return sendSyncRequest(request);
    }

}