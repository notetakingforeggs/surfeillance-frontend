package com.example.surfeillancefrontend.ui.spot.displayspot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.ActivitySpotDisplayBinding;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.model.repository.TripRepository;
import com.example.surfeillancefrontend.service.SpotApiService;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;

public class DisplaySpotActivity extends AppCompatActivity {
    SpotApiService spotApiService;
    ActivitySpotDisplayBinding binding;
    String TAG = "DisplaySpotActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_spot_display);
        binding.setLifecycleOwner(this);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            Location spot = getIntent().getParcelableExtra("Spot", Location.class);
            Log.d(TAG, "before binding: " + spot);
            if (spot != null) {
                binding.setSpot(spot);
                Log.d(TAG, "before posting: " + spot);

            } else {
                Log.i("null", "onCreate: ");
            }
            postTripAndReturnToHomePage(spot);

//            Log.i("test", spot.getName());
//            String name = spot.getName();
////            Log.i("test", "22222222222222");
//            String details = spot.getDetails();
//            String requestTime = spot.getRequestTime();
//            String latitude = spot.getLatitude();
//            String longitude = spot.getLongitude();
//            String timezone = spot.getTimezone();
//            Double waveHeight = spot.getWaveHeight();
//            String waveDirection = spot.getWaveDirection();
//            Double wavePeriod = spot.getWavePeriod();
//            Double windSpeed = spot.getWindSpeed();
//            Double gusts = spot.getGusts();
//            Double highTideHeight = spot.getHighTideHeight();
//            String highTideTime = spot.getHighTideTime();
//            Double lowTideHeight = spot.getLowTideHeight();
//            String lowTideTime = spot.getLowTideTime();
//            String windDirection = spot.getWindDirection();
//
//            TextView spotNameTV = findViewById(R.id.spotNameTV);
//            TextView spotDetailsTV = findViewById(R.id.descriptionTV);
//            TextView longitudeTV = findViewById(R.id.longitudeTV);
//            TextView latitudeTV = findViewById(R.id.latitudeTV);
//            TextView waveDirectionTV = findViewById(R.id.waveDirectionTV);
//            TextView timezoneTV = findViewById(R.id.timezoneTV);
//            TextView windDirectionTV = findViewById(R.id.windDirectionTV);
//
//            spotNameTV.setText(name);
//            spotDetailsTV.setText(details);
//            longitudeTV.setText(String.format("Longitude: %.6s", longitude));
//            latitudeTV.setText(latitude);
//            waveDirectionTV.setText(waveDirection);
//            timezoneTV.setText(timezone);
//            windDirectionTV.setText(String.format("Wind direction: %.6s", windDirection));


        }
        navigateToHomePage();
        navigateToSpotChoiceActivity();
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
    public void postTripAndReturnToHomePage(Location spot) {
        Button addTripAndReturnHome = (Button) findViewById(R.id.submitTripButton);
        addTripAndReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripRepository tripRepository = new TripRepository(getApplication());
                tripRepository.addTrip(spot);
                Toast.makeText(getApplicationContext(), "Your trip has been added to the database", Toast.LENGTH_LONG).show();
                // Start the new activity i.e. return to homepage after posting trip to DB
                Intent intent = new Intent(DisplaySpotActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

