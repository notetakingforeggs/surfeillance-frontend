package com.example.surfeillancefrontend.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AuthService {
    @GET("health")
    Call<String> authenticate(@Header("Authorization") String authHeader);
}
