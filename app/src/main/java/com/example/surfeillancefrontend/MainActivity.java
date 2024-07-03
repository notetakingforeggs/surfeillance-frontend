package com.example.surfeillancefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.ui.profile.ProfileActivity;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;
import com.example.surfeillancefrontend.ui.spot.trip.tripchoice.TripChoiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateToSpotChoiceActivity();
        navigateToUserAccount();
        navigateToUsersTrips();
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

    public void navigateToUsersTrips() {
        Button chooseTrip = (Button) findViewById(R.id.myTripsButton);
        chooseTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, TripChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
    public void navigateToUserAccount() {
        ImageButton userAccountButton = (ImageButton) findViewById(R.id.userAccount);
        userAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}