
package com.example.surfeillancefrontend.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request newRequest  = chain.request().newBuilder()
//                            .addHeader("Authorization", "Bearer " + token)
//                            .build();
//                    return chain.proceed(newRequest);
//                }
//            }).build();

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://172.23.223.86:8080/oauth/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
