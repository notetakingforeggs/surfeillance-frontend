package com.example.surfeillancefrontend.ui.trip.displaytrip;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.data.Trip;

public class DisplayTripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trip);

        Trip trip = (Trip)getIntent().getSerializableExtra("Trip");

    }
}