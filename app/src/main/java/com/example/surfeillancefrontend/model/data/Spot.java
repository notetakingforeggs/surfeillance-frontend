package com.example.surfeillancefrontend.model.data;

import com.example.surfeillancefrontend.model.data.Conditions.CurrentMarineData;
import com.example.surfeillancefrontend.model.data.Conditions.CurrentWeatherData;
import com.example.surfeillancefrontend.model.data.Conditions.LocationCoordinate;
import com.example.surfeillancefrontend.model.data.Conditions.TidalEvent;

public class Spot {
    Integer spotId;
    String locationName;
    LocationCoordinate coordinate;
    CurrentMarineData currentMarineData;
    CurrentWeatherData currentWeatherData;

  TidalEvent tidalEvent;

}
