package com.example.surfeillancefrontend.ui.spot.trip.tripchoice;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TripChoiceViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public TripChoiceViewModelFactory(Application application){
        this.application = application;
    }

    @NonNull
    @Override
    public<T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(TripChoiceViewModel.class)){
            return(T) new TripChoiceViewModel((application));
        }
        throw new IllegalArgumentException("unknown viewmodel");
    }
}
