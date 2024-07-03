package com.example.surfeillancefrontend.ui.spot.displayspot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;

public class DisplaySpotActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_display);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            Location spot = getIntent().getParcelableExtra("Spot", Location.class);

            String spotName = spot.getName();
            String spotDetails = spot.getDetails();
            String longitude = spot.getLongitude();
            String latitude = spot.getLatitude();
            String waveDirection = spot.getWaveDirection();
            String timezone = spot.getTimezone();

            TextView spotNameTV = findViewById(R.id.spotNameTV);
            TextView spotDetailsTV = findViewById(R.id.descriptionTV);
            TextView longitudeTV = findViewById(R.id.longitudeTV);
            TextView latitudeTV = findViewById(R.id.latitudeTV);
            TextView waveDirectionTV = findViewById(R.id.waveDirectionTV);
            TextView timezoneTV = findViewById(R.id.timezoneTV);

            spotNameTV.setText(spotName);
            spotDetailsTV.setText(spotDetails);
            longitudeTV.setText(longitude);
            latitudeTV.setText(latitude);
            waveDirectionTV.setText(waveDirection);
            timezoneTV.setText(timezone);
        }

        navigateToHomePage();
        navigateToSpotChoiceActivity();
        postTripAndReturnToHomePage();

    }
    public void navigateToHomePage() {
        ImageButton goHomeButton = (ImageButton) findViewById(R.id.returnHome);
        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(DisplaySpotActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void navigateToSpotChoiceActivity() {
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(DisplaySpotActivity.this, SpotChoiceActivity.class);
                startActivity(intent);
            }
        });
    }

    public void postTripAndReturnToHomePage() {
        Button addTripAndReturnHome = (Button) findViewById(R.id.addTrip);
        addTripAndReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to homepage after posting trip to DB
                Intent intent = new Intent(DisplaySpotActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

