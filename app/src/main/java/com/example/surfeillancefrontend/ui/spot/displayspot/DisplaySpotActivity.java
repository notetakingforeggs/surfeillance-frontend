package com.example.surfeillancefrontend.ui.spot.displayspot;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.data.Location;

public class DisplaySpotActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_display);

        Location item = getIntent().getParcelableExtra("item");

        if (item!= null) {
            TextView spotName = findViewById(R.id.spotName);
            TextView longitude = findViewById(R.id.longitude);
            TextView latitude = findViewById(R.id.latitude);
            TextView timezone = findViewById(R.id.timezone);
            TextView waveDirection = findViewById(R.id.waveDirection);
        }
    }
}
