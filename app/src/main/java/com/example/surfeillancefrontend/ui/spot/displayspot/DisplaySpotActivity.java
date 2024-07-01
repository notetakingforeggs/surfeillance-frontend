package com.example.surfeillancefrontend.ui.spot.displayspot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.ui.spot.spotchoice.SpotChoiceActivity;

public class DisplaySpotActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_display);

        String spotName = getIntent().getStringExtra("spotName");
        String spotDetails = getIntent().getStringExtra("details");
        String longitude = getIntent().getStringExtra("longitude");
        String latitude = getIntent().getStringExtra("latitude");
        String waveDirection = getIntent().getStringExtra("waveDirection");
        String timezone = getIntent().getStringExtra("timezone");

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

        navigateToHomePage();
        navigateToSpotChoiceActivity();
    }
    public void navigateToHomePage() {
        ImageButton back = (ImageButton) findViewById(R.id.returnHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(DisplaySpotActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void navigateToSpotChoiceActivity() {
        ImageButton back = (ImageButton) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(DisplaySpotActivity.this, SpotChoiceActivity.class);
                startActivity(intent);
            }
        });
    }

}

