package com.example.surfeillancefrontend.model.data;

public class Trip {

    int tripID;
    Integer userID;
    String dateTime;
    Location locationConditions;


    public Trip(int tripID, Integer userID, String dateTime, Location locationConditions) {
        this.tripID = tripID;
        this.userID = userID;
        this.dateTime = dateTime;
        this.locationConditions = locationConditions;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Location getLocationConditions() {
        return locationConditions;
    }

    public void setLocationConditions(Location locationConditions) {
        this.locationConditions = locationConditions;
    }

}

