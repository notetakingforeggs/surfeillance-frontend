package com.example.surfeillancefrontend.ui.trip.editTrip;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.model.repository.TripRepository;

public class EditTripViewModel extends AndroidViewModel {
    TripRepository tripRepository;

    public EditTripViewModel(Application application ){
    super(application);
    this.tripRepository = new TripRepository(application);
    }
    public Trip editTripInfo(Trip editedTrip){
        return tripRepository.editTripInfo(editedTrip);
    }
}
