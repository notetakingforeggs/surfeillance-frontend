package com.example.surfeillancefrontend.ui.spot.spotchoice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.RecyclerViewInterface;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.service.ApiClient;
import com.example.surfeillancefrontend.service.SpotApiService;
import com.example.surfeillancefrontend.ui.spot.displayspot.DisplaySpotActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class SpotChoiceActivity extends AppCompatActivity implements RecyclerViewInterface {
    SpotAdapter adapter;
    List<Location> spots;
    RecyclerView recyclerView;
    SpotApiService spotApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // You must implement this callback, which fires when the system creates your activity. Your implementation should initialize the essential components of your activity; for example, your app should create views and bind data to lists here.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_choice); // you must call setContentView() to define the layout for the activity's user interface. This method sets the content of the Activity to the specified layout, effectively populating the Activity’s window with the UI elements defined in the layout file. The method can take either a layout resource ID or a View object as its parameter. “Inflating a layout” in Android refers to the process of converting an XML layout file into a hierarchy of View objects that can be displayed on the screen - this code doe so implicitly but you can explicitly inflate a layout as follows:
        // LayoutInflater inflater = LayoutInflater.from(context);
        // View inflatedView = inflater.inflate(R.layout.your_layout, null);
        // setContentView(inflatedView);
        navigateToPreviousActivity();
        navigateToHomePage();

        recyclerView = findViewById(R.id.recyclerViewOfSpots);
        // Instantiate a LinearLayoutManager class to allow the items to be displayed in a linear scrolling vertical list and assign this layout to the recyclerView variable
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // The context is this, referring to the current activity
        recyclerView.setLayoutManager(layoutManager);
        spotApiService = ApiClient.getInstance().create(SpotApiService.class);
                spotApiService.getAllSpots().enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                spots = response.body();
                adapter = new SpotAdapter(spots, SpotChoiceActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable throwable) {
                Log.d("test", "HTTP GET request NOT sent");
            }
        });

        // Delete this and the following 18 lines after data can be pulled from API:
//        spots = new ArrayList<>();
//        String description = "Swell spot! Loved my trip! Great surf, showers, electric chargers, tuition, food shack - happy times were shared with friends old and new";
//        Location location1 = new Location("Fistral North", description, "50.25", "-4.75", "GMT","SW");
//        Location location2 = new Location("Fistral South", description, "51.25", "-3.75", "GTB","NE");
//        Location location3 = new Location("Fistral East", description, "41.25", "-1.75", "UTC","NE");
//        Location location4 = new Location("Fistral West", description, "41.25", "-1.75", "UTC","NE");
//        Location location5 = new Location("East Fistral", description, "41.25", "-1.75", "UTC","NE");
//        Location location6 = new Location("West Fistral", description, "41.25", "-1.75", "UTC","NE");
//        Location location7 = new Location("North Fistral", description, "41.25", "-1.75", "UTC","NE");
//        Location location8 = new Location("South Fistral", description, "41.25", "-1.75", "UTC","NE");
//        spots.add(location1);
//        spots.add(location2);
//        spots.add(location3);
//        spots.add(location4);
//        spots.add(location5);
//        spots.add(location6);
//        spots.add(location7);
//        spots.add(location8);
//
//        adapter = new SpotAdapter(spots, this);
//        recyclerView.setAdapter(adapter); // sets adapter to the recyclerView
    } // When onCreate() finishes, the next callback is always onStart(). As onCreate() exits, the activity enters the Started state, and the activity becomes visible to the user. This callback contains what amounts to the activity’s final preparations for coming to the foreground and becoming interactive.

    public void navigateToPreviousActivity() {
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(SpotChoiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void navigateToHomePage() {
        ImageButton goHomeButton = (ImageButton) findViewById(R.id.returnHome);
        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(SpotChoiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(SpotChoiceActivity.this, DisplaySpotActivity.class); // this code navigates from 1 Activity to another
        Location spot = spots.get(position); // this code takes a Location spot at the argued position from the List<Location> spots
        intent.putExtra("Spot", spot); // putExtra() sends whatever data you pass as an argument to the new Activity
        startActivity(intent); // this code switches the current Activity to the new Activity and passes a Location object called spot
    }
}