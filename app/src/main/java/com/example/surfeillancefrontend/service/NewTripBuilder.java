package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.model.data.NewTrip;
import com.example.surfeillancefrontend.model.data.Spot;
import com.example.surfeillancefrontend.model.data.dto.AppUser;

import java.time.LocalDate;

public class NewTripBuilder {
    private Spot spot;
    private AppUser user;
    private String date;
    private Location location;
    private NewTrip constructedTrip;

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

    public NewTrip build() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
            date = currentDate.toString();
        }



//        Date highTime = null;
//        Date lowTime = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            OffsetDateTime offsetDateTimeLow = OffsetDateTime.parse(location.getLowTideTime(), DateTimeFormatter.BASIC_ISO_DATE);
//            OffsetDateTime offsetDateTimeHigh = OffsetDateTime.parse(location.getHighTideTime(), DateTimeFormatter.BASIC_ISO_DATE);
//
//            Log.i("in builder", "build: ");
//            highTime = Date.from(offsetDateTimeHigh.toInstant());
//            lowTime = Date.from(offsetDateTimeLow.toInstant());
//
//            Log.i("TAG", "build: " + highTime);


            constructedTrip = new NewTrip(user,
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
                    location.getLowTideTime(),
                    location.getHighTideTime()
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