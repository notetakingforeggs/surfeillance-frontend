package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.AuthResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AuthService {
    @GET("health")
    Call<AuthResponse> authenticate();
}
