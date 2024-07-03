package com.example.surfeillancefrontend.ui.trip.tripchoice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.ActivityTripChoiceBinding;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.ui.trip.displaytrip.DisplayTripActivity;

import java.util.ArrayList;
import java.util.List;

public class TripChoiceActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private List<Trip> tripList;
    private TripChoiceAdaptor tripAdaptor;
    private TripChoiceViewModel viewModel;
    private ActivityTripChoiceBinding binding;
    // clickhandler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_choice);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_choice);
        TripChoiceViewModelFactory factory = new TripChoiceViewModelFactory(getApplication());
        viewModel = new ViewModelProvider(this, factory).get(TripChoiceViewModel.class);
        binding.setLifecycleOwner(this);
        getAllTrips();

    }

    private void getAllTrips() {
        viewModel.getData().observe(this, new Observer<List<Trip>>() {
            @Override
            public void onChanged(List<Trip> trips) {
                if (trips != null && !trips.isEmpty()) {
                    tripList = new ArrayList<>(trips);
                    for (Trip trip : tripList) {
                        Log.i("?", "locations in list" + trip.getLocationConditions().getName());
                    }
                    displayInRecyclerView(tripList);
                } else {
                    Log.i(trips.get(0).getLocationConditions().getName(), "XXXXXXXXXXXXXXXXXXx: ");
                }
            }
        });
    }

    private void displayInRecyclerView(List<Trip> trips) {
        Log.i("TAG", (trips.get(2).getLocationConditions().getName().toString()));
        recyclerView = binding.recyclerViewTrips;
        tripAdaptor = new TripChoiceAdaptor(trips, this, this);
        recyclerView.setAdapter(tripAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //tripAdaptor.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Log.i("0", "onItemClick: ");
        Intent intent = new Intent(this, DisplayTripActivity.class); // this code navigates from 1 Activity to another
        Log.i("1", "onItemClick: ");
        Trip trip = tripList.get(position); // this code takes a Location spot at the argued position from the List<Location> spots
        Log.i("2", "onItemClick: ");
        intent.putExtra("Trip", trip); // putExtra() sends whatever data you pass as an argument to the new Activity
        Log.i("3", "onItemClick: ");
        startActivity(intent); // this code switches the current Activity to the new Activity and passes a Location object called spot
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}

