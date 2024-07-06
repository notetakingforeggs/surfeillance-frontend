package com.example.surfeillancefrontend.model.repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillancefrontend.model.data.DTO.UpdateRatingDTO;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.service.ApiClient;
import com.example.surfeillancefrontend.service.TripApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class TripRepository {
    private final MutableLiveData<List<Trip>> liveData = new MutableLiveData<>();
//    private TripDTO returnedTripDTO;
    private Trip returnedTrip;
    private Application app;
    private final TripApiService tripApiService;
  //  private final TripApiService tripApiServiceCustom;
//    private TripDeserialiser customGson;


    public TripRepository(Application app) {
        this.app = app;
        tripApiService = ApiClient.getInstance().create(TripApiService.class);
//        customGson = new TripDeserialiser();
//
//        Gson gson = new GsonBuilder().registerTypeAdapter(Trip.class, new TripDeserialiser()).create();
//        tripApiServiceCustom = ApiClient.getInstance(gson).create(TripApiService.class);
    }

    public MutableLiveData<List<Trip>> getMutableLiveDate() {

        // currently hardcoded but should take user id from active session once we have that implemented
        Call call = tripApiService.getTripsByUserId("1");

        call.enqueue(new Callback<List<Trip>>() {
            @Override
            public void onResponse(Call<List<Trip>> call, Response<List<Trip>> response) {
                List<Trip> trips = response.body();
                liveData.setValue(trips);
            }

            @Override
            public void onFailure(Call<List<Trip>> call, Throwable throwable) {
                Log.i("Get Trips Failing at apicall", "onFailure: ");
            }
        });
        return liveData;
    }

    public Trip editTripInfo(Trip editedTrip) {
       UpdateRatingDTO ratings = new UpdateRatingDTO(editedTrip.getSurfRating(), editedTrip.getInfoRating());
        Call call = tripApiService.editTripByTripId(editedTrip.getTripId(), ratings );
         call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                returnedTrip = (Trip) response.body();
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                Log.i(
                        "repo faill edit", "onFailure: ");
            }
        });
         return returnedTrip;
    }
}




