package com.example.surfeillancefrontend.ui.trip.editTrip;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.R;
import com.google.android.material.textfield.TextInputEditText;

public class EditTripActivity extends AppCompatActivity {
RatingBar ratingBar;
TextInputEditText editText;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trip);
        addListenerOnButtonClick();

    }
        public void addListenerOnButtonClick() {
            ratingBar = findViewById(R.id.ratingBar1);
            button = (Button) findViewById(R.id.submitEditedTripButton);

            //Performing action on Button Click
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    //Getting the rating and displaying it on the toast
                    String rating = String.valueOf(ratingBar.getRating());
                    Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
                }
            });
        }
        }
