
package com.example.surfeillancefrontend.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiClientLogin {
    private static Retrofit retrofitLogin;
    private static String token;


    public static Retrofit getInstance() {
        if (retrofitLogin == null) {




            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofitLogin = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitLogin;
    }
}
