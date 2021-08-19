//
//  Created by  fred on 2016/10/26.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.zz.example;

import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Demopsa_o2o_prod {


    static {
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("203815642");
        httpParam.setAppSecret("");
        HttpApiClientpsa_o2o_prod.getInstance().init(httpParam);


        //HTTPS Client init
        HttpClientBuilderParams httpsParam = new HttpClientBuilderParams();
        httpsParam.setAppKey("");
        httpsParam.setAppSecret("");

        /**
         * HTTPS request use DO_NOT_VERIFY mode only for demo
         * Suggest verify for security
         */
        //httpsParam.setRegistry(getNoVerifyRegistry());

        HttpsApiClientpsa_o2o_prod.getInstance().init(httpsParam);


    }

    public static void DCS_同步服务包使用情况HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().DCS_同步服务包使用情况(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void DCS_同步服务包使用情况HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().DCS_同步服务包使用情况SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void DCS_同步服务包使用情况HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().DCS_同步服务包使用情况(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void DCS_同步服务包使用情况HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().DCS_同步服务包使用情况SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_aso_查询维保记录_anlianHttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询维保记录_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_查询维保记录_anlianHttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询维保记录_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_aso_查询维保记录_anlianHttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询维保记录_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_查询维保记录_anlianHttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询维保记录_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_线索流入HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_线索流入(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_线索流入HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_线索流入SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_线索流入HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_线索流入(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_线索流入HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_线索流入SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_lead_线索清洗HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_lead_线索清洗(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_lead_线索清洗HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_lead_线索清洗SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_lead_线索清洗HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_lead_线索清洗(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_lead_线索清洗HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_lead_线索清洗SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void 安联_获查询整车销售订单HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().安联_获查询整车销售订单(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 安联_获查询整车销售订单HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().安联_获查询整车销售订单SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void 安联_获查询整车销售订单HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().安联_获查询整车销售订单(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 安联_获查询整车销售订单HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().安联_获查询整车销售订单SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void 车联网_查询消费者积分账户信息HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分账户信息(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 车联网_查询消费者积分账户信息HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分账户信息SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void 车联网_查询消费者积分账户信息HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分账户信息(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 车联网_查询消费者积分账户信息HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分账户信息SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void 车联网_查询消费者积分流水HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分流水(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 车联网_查询消费者积分流水HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分流水SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void 车联网_查询消费者积分流水HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分流水(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 车联网_查询消费者积分流水HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().车联网_查询消费者积分流水SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_mdm_查询客户以及对应车辆信息_anlianHttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_mdm_查询客户以及对应车辆信息_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_mdm_查询客户以及对应车辆信息_anlianHttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_mdm_查询客户以及对应车辆信息_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_mdm_查询客户以及对应车辆信息_anlianHttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_mdm_查询客户以及对应车辆信息_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_mdm_查询客户以及对应车辆信息_anlianHttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_mdm_查询客户以及对应车辆信息_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_aso_创建预约维保信息_anlianHttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建预约维保信息_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_创建预约维保信息_anlianHttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建预约维保信息_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_aso_创建预约维保信息_anlianHttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建预约维保信息_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_创建预约维保信息_anlianHttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建预约维保信息_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_aso_查询预约维保信息_anlianHttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询预约维保信息_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_查询预约维保信息_anlianHttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询预约维保信息_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_aso_查询预约维保信息_anlianHttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询预约维保信息_anlian(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_查询预约维保信息_anlianHttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_查询预约维保信息_anlianSyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_aso_创建维保信息HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建维保信息(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_创建维保信息HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建维保信息SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_aso_创建维保信息HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建维保信息(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_aso_创建维保信息HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_aso_创建维保信息SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_实销上报HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_实销上报(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_实销上报HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_实销上报SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_实销上报HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_实销上报(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_实销上报HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_实销上报SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_dsc订单跟进HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_dsc订单跟进(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_dsc订单跟进HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_dsc订单跟进SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_dsc订单跟进HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_dsc订单跟进(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_dsc订单跟进HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_dsc订单跟进SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void O2O_PROD_同步dcs库存HttpTest() {
        HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_同步dcs库存(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_同步dcs库存HttpSyncTest() {
        ApiResponse response = HttpApiClientpsa_o2o_prod.getInstance().O2O_PROD_同步dcs库存SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void O2O_PROD_同步dcs库存HttpsTest() {
        HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_同步dcs库存(new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void O2O_PROD_同步dcs库存HttpsSyncTest() {
        ApiResponse response = HttpsApiClientpsa_o2o_prod.getInstance().O2O_PROD_同步dcs库存SyncMode();
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        result.append("ResultCode:").append(SdkConstant.CLOUDAPI_LF).append(response.getCode()).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        if (response.getCode() != 200) {
            result.append("Error description:").append(response.getHeaders().get("X-Ca-Error-Message")).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        }

        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody(), SdkConstant.CLOUDAPI_ENCODING));

        return result.toString();
    }

    private static Registry<ConnectionSocketFactory> getNoVerifyRegistry() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        try {
            registryBuilder.register("http", PlainConnectionSocketFactory.INSTANCE).build();
            registryBuilder.register(
                    "https",
                    new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(
                            KeyStore.getInstance(KeyStore.getDefaultType()), new TrustStrategy() {
                                @Override
                                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                                    return true;
                                }
                            }).build(),
                            new HostnameVerifier() {
                                @Override
                                public boolean verify(String paramString, SSLSession paramSSLSession) {
                                    return true;
                                }
                            }));

        } catch (Exception e) {
            throw new RuntimeException("HttpClientUtil init failure !", e);
        }
        return registryBuilder.build();
    }


    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements TrustManager,
            X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }

        public void checkClientTrusted(
                X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }
    }
}
