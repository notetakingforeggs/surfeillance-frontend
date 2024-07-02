package com.example.surfeillancefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;
import com.example.surfeillancefrontend.ui.spot.trip.tripchoice.TripChoiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateToTripChoiceActivity();

    }
    public void navigateToSpotChoiceActivity() {
        Button chooseTrip = (Button) findViewById(R.id.chooseSpotButton);
        chooseTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, SpotChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
    public void navigateToTripChoiceActivity() {
        Button myTrips = findViewById(R.id.myTripsButton);
        myTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, TripChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
}