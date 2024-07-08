
package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.DTO.TokenHolder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiClient {
    private static Retrofit retrofit;
    private static String token;


    public static Retrofit getInstance() {
        if (retrofit == null) {
            String token = TokenHolder.getInstance().getToken();
            // where do we get token from?
           // token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjU2OTFhMTk1YjI0MjVlMmFlZDYwNjMzZDdjYjE5MDU0MTU2Yjk3N2QiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiam9uYWggcnVzc2VsbCIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS9BQ2c4b2NKM3FMUTJZYVdXOWlJTGRocEpvMWp3QjZXeS1xX1VRcEYzM3ZqZHdrcWNZTXJhQWc9czk2LWMiLCJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vc3VyZmVpbGxhbmNlLTY0N2YwIiwiYXVkIjoic3VyZmVpbGxhbmNlLTY0N2YwIiwiYXV0aF90aW1lIjoxNzIwNDQzODY2LCJ1c2VyX2lkIjoiUnNES2k2djdteWdHamZ1MDZrQURFUGhISnBhMiIsInN1YiI6IlJzREtpNnY3bXlnR2pmdTA2a0FERVBoSEpwYTIiLCJpYXQiOjE3MjA0NDM4NjcsImV4cCI6MTcyMDQ0NzQ2NywiZW1haWwiOiJub3RldGFraW5nZm9yZWdnc0BnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJnb29nbGUuY29tIjpbIjExMjI3MTgwOTQ4Njg5NzgyMTAwNSJdLCJlbWFpbCI6WyJub3RldGFraW5nZm9yZWdnc0BnbWFpbC5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJnb29nbGUuY29tIn19.V-EDGSjRZ2BedyQlSu4ZJ897iqc78oYqIhYWtpNk1E8L1YWzgOMHbPDD54BVPt-AN5Kg1UtluH55T1h9AlbDkRj1nHHVPN0G0kA8yM3cdVGDwSjdVhSkUDHlhDoRCX2IYCAH-xwPHRHY16rDP7VIYalWJgP50ORlHbwTpuokTQRmTa1vJ73QjY6aRsVl1sZ97NVwuPo5iKjmMLwOgY5zfY4MySeanyGadCj0IC8OPvxSFJnoBf1n0bKnpa0RSSrcZ8Ik7bOC08vk69VPMv-grFvqEroqfhv6czeK2c7Kqr-AVL0genQ6DnxiLAR7niR0HuMj-8i66FrGVmWKKnTh2g";
            System.out.println("retrofit initialised");


            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @NotNull
                        @Override
                        public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", "Bearer " + token )
                                    .build();
                            return chain.proceed(newRequest);
                        }})
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://10.0.2.2:8080/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
