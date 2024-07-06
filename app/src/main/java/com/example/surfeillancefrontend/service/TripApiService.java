package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.DTO.UpdateRatingDTO;
import com.example.surfeillancefrontend.model.data.Trip;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface TripApiService {


    @GET("users/trips/{userid}")
    Call<List<Trip>> getTripsByUserId(@Path("userid") String userid);



    @PUT("users/trips/{tripid}")
    Call<Trip> editTripByTripId(@Path("tripid") int tripid, @Body UpdateRatingDTO ratings);

}
