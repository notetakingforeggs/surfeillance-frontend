package com.example.surfeillancefrontend.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Trip implements Parcelable {

    Integer tripID;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(tripID.toString());
        dest.writeString(userID.toString());
        dest.writeString(dateTime);
        dest.writeString(locationConditions.details);
        dest.writeString(locationConditions.name);
        dest.writeString(locationConditions.waveDirection);
        dest.writeString(locationConditions.waveHeight.toString());
        dest.writeString(locationConditions.wavePeriod.toString());
        dest.writeString(locationConditions.windSpeed.toString());
        dest.writeString(locationConditions.gusts.toString());
        dest.writeString(locationConditions.latitude);
        dest.writeString(locationConditions.longitude);
        dest.writeString(locationConditions.highTideTime);
        dest.writeString(locationConditions.highTideHeight.toString());
        dest.writeString(locationConditions.lowTideTime);
        dest.writeString(locationConditions.lowTideHeight.toString());
        dest.writeString(locationConditions.requestTime);
        dest.writeString(locationConditions.timezone);

    }
}

