package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.Location;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface SpotApiService {
    // This is where the Retrofit HTTP methods will be declared
    // A Retrofit Call<T> object abstracts the details of making network
    // requests, providing a flexible and powerful mechanism for handling
    // HTTP requests and responses in a type-safe manner

    @GET("conditions")
    Call<List<Location>> getAllSpots(); // i.e., with the @GET annotation, this method is making a GET request to the "/spots" endpoint and expects a list of Location objects in return. Different annotations are used to specify the HTTP request type: GET, POST, PUT, DELETE

    // needs to send more info to build a trip - userid?
    @POST("users/trips/add")
    Call<Location> postSpot(@Body Location spot);
}
