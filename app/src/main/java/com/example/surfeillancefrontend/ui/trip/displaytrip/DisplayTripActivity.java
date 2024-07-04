package com.example.surfeillancefrontend.ui.trip.displaytrip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.ActivityDisplayTripBinding;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.ui.trip.editTrip.EditTripActivity;

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
        if (trip != null) {
            binding.setTrip(trip);
        } else {
            Log.i("null", "onCreate: ");
        }
    }
   public void onEditButtonClick(View v) {
       Log.i("TAG", "onEditButtonClick: ");
        Intent intent = new Intent(this, EditTripActivity.class);
      //  intent.putExtra("Trip", trip);
        startActivity(intent);
    }
}