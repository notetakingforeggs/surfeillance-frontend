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

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(LocationCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public CurrentMarineData getCurrentMarineData() {
        return currentMarineData;
    }

    public void setCurrentMarineData(CurrentMarineData currentMarineData) {
        this.currentMarineData = currentMarineData;
    }

    public CurrentWeatherData getCurrentWeatherData() {
        return currentWeatherData;
    }

    public void setCurrentWeatherData(CurrentWeatherData currentWeatherData) {
        this.currentWeatherData = currentWeatherData;
    }

    public TidalEvent getTidalEvent() {
        return tidalEvent;
    }

    public void setTidalEvent(TidalEvent tidalEvent) {
        this.tidalEvent = tidalEvent;
    }
}
