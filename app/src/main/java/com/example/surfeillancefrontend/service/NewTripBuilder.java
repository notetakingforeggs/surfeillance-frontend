package com.example.surfeillancefrontend.service;

import android.util.Log;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.model.data.NewTrip;
import com.example.surfeillancefrontend.model.data.Spot;
import com.example.surfeillancefrontend.model.data.dto.AppUser;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class NewTripBuilder {
    private Spot spot;
    private AppUser user;
    private String date;
    private Location location;

    public NewTripBuilder withSpot(Spot spot) {
        this.spot = spot;
        return this;
    }

    public NewTripBuilder withUser(AppUser user) {
        this.user = user;
        return this;
    }

    public NewTripBuilder withLocation(Location location) {
        this.location = location;
        return this;
    }

    public NewTrip build()  {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
            date = currentDate.toString();
        }
        Log.i("in builder", "build: ");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date highTime = null;
        Date lowTime = null;
        try {
            highTime = formatter.parse(location.getHighTideTime());
            lowTime = formatter.parse(location.getLowTideTime());
        } catch (Exception e) {
            Log.i("New trip building", "date parsing ");
            e.printStackTrace();
        }
        NewTrip constructedTrip = new NewTrip(user,
                spot,
                date,
                location.getWaveHeight().doubleValue(),
                location.getWaveDirection(),
                location.getWavePeriod().doubleValue(),
                // windspeed is null, which is not ok
                0,
                location.getWindDirection(),
                (int) Math.round(location.getGusts()),
                location.getLowTideHeight(),
                location.getHighTideHeight(),

                highTime,
                lowTime
        );

        return constructedTrip;
    }
}
/*    private int tripId;
    private AppUserDTO appUserDTO;
    private Spot spot;
    private Integer surfRating;
    private Integer infoRating;
    private String date;
    private double waveHeight;
    private String waveDirection;
    private double wavePeriod;
    private double windSpeed;
    private String windDirection;
    private int gusts;
    private Double lowTideHeight;
    private Double highTideHeight;
    private String lowTideDate;
    private String highTideDate;*/