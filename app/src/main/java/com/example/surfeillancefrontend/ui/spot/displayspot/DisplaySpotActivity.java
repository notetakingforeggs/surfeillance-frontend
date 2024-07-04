package com.example.surfeillancefrontend.ui.spot.displayspot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.service.ApiClient;
import com.example.surfeillancefrontend.service.SpotApiService;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplaySpotActivity extends AppCompatActivity {
    SpotApiService spotApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_display);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            Location spot = getIntent().getParcelableExtra("Spot", Location.class);
            Log.i("test", spot.getName());
            String name = spot.getName();
            Log.i("test", "22222222222222");
            String details = spot.getDetails();
            String requestTime = spot.getRequestTime();
            String latitude = spot.getLatitude();
            String longitude = spot.getLongitude();
            String timezone = spot.getTimezone();
            Double waveHeight = spot.getWaveHeight();
            String waveDirection = spot.getWaveDirection();
            Double wavePeriod = spot.getWavePeriod();
            Double windSpeed = spot.getWindSpeed();
            Double gusts = spot.getGusts();
            Double highTideHeight = spot.getHighTideHeight();
            String highTideTime = spot.getHighTideTime();
            Double lowTideHeight = spot.getLowTideHeight();
            String lowTideTime = spot.getLowTideTime();



            TextView spotNameTV = findViewById(R.id.spotNameTV);
            TextView spotDetailsTV = findViewById(R.id.descriptionTV);
            TextView longitudeTV = findViewById(R.id.longitudeTV);
            TextView latitudeTV = findViewById(R.id.latitudeTV);
            TextView waveDirectionTV = findViewById(R.id.waveDirectionTV);
            TextView timezoneTV = findViewById(R.id.timezoneTV);

            spotNameTV.setText(name);
            spotDetailsTV.setText(details);
            longitudeTV.setText(longitude);
            latitudeTV.setText(latitude);
            waveDirectionTV.setText(waveDirection);
            timezoneTV.setText(timezone);

            postTripAndReturnToHomePage(spot);

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
        Button addTripAndReturnHome = (Button) findViewById(R.id.addTrip);
        addTripAndReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient.getInstance().create(SpotApiService.class).postSpot(spot).enqueue(new Callback<Location>() {
                    @Override
                    public void onResponse(Call<Location> call, Response<Location> response) {
                        if (response.isSuccessful()) {
                            Location responseBody = response.body();
                            // Handle the response body
                            Log.d("test", "onResponse() method invoked for POST request");
                            Log.d("test", responseBody.getName());
                            Toast.makeText(getApplicationContext(), "Added to your trips", Toast.LENGTH_LONG).show();
                        } else {
                            // Handle the error
                            Log.d("test", "response unsuccessful");
                            int statusCode = response.code();
                            Log.e("API CALL", "Error: " + statusCode);
                        }
                    }

                    @Override
                    public void onFailure(Call<Location> call, Throwable throwable) {
                        Log.d("test", "onFailure() method called for POST request");
                        Log.e("API CALL", "Failure: ", throwable);
                    }

                });


                // Start the new activity i.e. return to homepage after posting trip to DB
                Intent intent = new Intent(DisplaySpotActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }


}

