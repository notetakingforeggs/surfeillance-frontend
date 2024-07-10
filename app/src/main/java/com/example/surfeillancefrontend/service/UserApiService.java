package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.example.surfeillancefrontend.model.data.dto.AppUserDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApiService {

    @POST("users/add")
    Call<AppUser> addUser(@Body AppUserDTO user);

    @GET("users/email/{email}")
    Call<AppUser> getUserByEmail(@Path("email")String email);
}
