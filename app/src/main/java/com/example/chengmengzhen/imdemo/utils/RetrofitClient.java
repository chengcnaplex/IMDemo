package com.example.chengmengzhen.imdemo.utils;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by APLEX on 2016/7/22.
 */
public class RetrofitClient {

    private static Retrofit mRetrofitClient;
    private static final  String API_URL = "http://10.0.2.2:8080/Restful/rest/";
    private RetrofitClient() {

    }

    public static Retrofit getRetrofit() {
        if (mRetrofitClient == null) {
            synchronized (RetrofitClient.class) {
                if (mRetrofitClient == null) {
                    mRetrofitClient = new Retrofit.Builder()
                            .baseUrl(API_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return mRetrofitClient;
    }

}
