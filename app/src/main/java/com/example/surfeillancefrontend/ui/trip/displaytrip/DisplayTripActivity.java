package com.example.surfeillancefrontend.ui.trip.displaytrip;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.ActivityDisplayTripBinding;
import com.example.surfeillancefrontend.model.data.Trip;

public class DisplayTripActivity extends AppCompatActivity {

    ActivityDisplayTripBinding binding;
    Trip trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set up data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_trip);
        binding.setLifecycleOwner(this);

        // get trip from extra
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
             trip = getIntent().getParcelableExtra("Trip", Trip.class);
        } else {
             trip = getIntent().getParcelableExtra("Trip");
        }
        Log.i(trip.getDateTime(), "onCreate: ");

        if (trip != null) {
            binding.setTrip(trip);
        }else{
            Log.i("tripDataMissing", "onCreate: ");
        }

    }
}