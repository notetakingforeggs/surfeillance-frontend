package com.example.surfeillancefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.example.surfeillancefrontend.ui.profile.ProfileActivity;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;
import com.example.surfeillancefrontend.ui.trip.tripchoice.TripChoiceActivity;

public class MainActivity extends AppCompatActivity {
AppUser appUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_MyApp);

        setContentView(R.layout.activity_main);

        // get trip from extra
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            appUser = getIntent().getParcelableExtra("User", AppUser.class);
        } else {
            appUser = getIntent().getParcelableExtra("User");
        }
        navigateToSpotChoiceActivity();
        navigateToUserAccount();
        navigateToUsersTrips();

    }
    public void navigateToSpotChoiceActivity() {
        Button chooseTrip = (Button) findViewById(R.id.chooseSpotButton);
        chooseTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Intent intent = new Intent(MainActivity.this, TripChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
    public void navigateToUserAccount() {
        Button userAccountButton = (Button) findViewById(R.id.userAccount);
        userAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("User", appUser);
                startActivity(intent);
            }
        });
    }
}