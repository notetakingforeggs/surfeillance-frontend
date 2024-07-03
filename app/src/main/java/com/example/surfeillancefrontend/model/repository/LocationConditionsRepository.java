package com.example.surfeillancefrontend.model.repository;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillancefrontend.model.data.Location;

import java.util.List;

public class LocationConditionsRepository {
    MutableLiveData<List<Location>> mutableLiveDataSpotList = new MutableLiveData<>();
    Application application;

    public LocationConditionsRepository(Application application) {
        this.application = application;
    }

//    public MutableLiveData<List<Location>> getMutableLiveData() {
//        // implement
//    }
}
