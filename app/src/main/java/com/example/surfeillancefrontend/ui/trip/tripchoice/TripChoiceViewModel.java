package com.example.surfeillancefrontend.ui.trip.tripchoice;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.model.repository.TripRepository;

import java.util.List;

public class TripChoiceViewModel extends AndroidViewModel {
    TripRepository tripRepository;

    public TripChoiceViewModel(Application application) {
        super(application);
        this.tripRepository = new TripRepository(application);
    }
    public MutableLiveData<List<Trip>> getData() {
        return tripRepository.getMutableLiveDate();
    }
}

