//package com.example.surfeillancefrontend.model.repository;
//
//import android.app.Application;
//import android.util.Log;
//import android.widget.Toast;
//import androidx.lifecycle.MutableLiveData;
//import com.example.surfeillancefrontend.model.data.Location;
//import com.example.surfeillancefrontend.service.ApiClient;
//import com.example.surfeillancefrontend.service.SpotApiService;
//import retrofit2.Callback;
//
//import java.util.List;
//
//public class LocationRepository {
//    MutableLiveData<List<Location>> mutableLiveDataSpotList = new MutableLiveData<>();
//    Application application;
//    Api
//
//    public LocationRepository(Application application) {
//        this.application = application;
//    }
//
//    ApiClient.getInstance().create(SpotApiService .class).postSpot(spot).enqueue(new Callback<Location>() {
//        @Override
//        public void onResponse(Call<Location> call, Response<Location> response) {
//            if (response.isSuccessful()) {
//                Location responseBody = response.body();
//                // Handle the response body
//                Log.d("test", "onResponse() method invoked for POST request");
//                Log.d("test", responseBody.getName());
//                Toast.makeText(getApplicationContext(), "Added to your trips", Toast.LENGTH_LONG).show();
//            } else {
//                // Handle the error
//                Log.d("test", "response unsuccessful");
//                int statusCode = response.code();
//                Log.e("API CALL", "Error: " + statusCode);
//            }
//
//}
