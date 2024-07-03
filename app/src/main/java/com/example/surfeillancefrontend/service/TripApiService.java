package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.Trip;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface TripApiService {
//    @GET("faketrips")
//    Call<List<Trip>> getTrips();


    @GET("faketrips")
    Call<List<Trip>> getTripsByUserId(@Query("userid") String userid);


}
