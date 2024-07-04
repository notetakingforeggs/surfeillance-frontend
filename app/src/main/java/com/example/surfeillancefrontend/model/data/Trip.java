package com.example.surfeillancefrontend.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Trip implements Parcelable {

    Integer tripID;
    Integer userID;
    String dateTime;
    Integer surfRating;
    Integer infoRating;
    Location locationConditions;


    public Trip(Integer tripID, Integer userID, String dateTime, int surfRating, int infoRating, Location locationConditions) {
        this.tripID = tripID;
        this.userID = userID;
        this.dateTime = dateTime;
        this.surfRating = surfRating;
        this.infoRating = infoRating;
        this.locationConditions = locationConditions;
    }

    public Trip(Integer tripID, Integer userID, String dateTime, Location locationConditions) {
        this.tripID = tripID;
        this.userID = userID;
        this.surfRating = null;
        this.infoRating = null;
        this.dateTime = dateTime;
        this.locationConditions = locationConditions;
    }

    public static final Creator<Trip> CREATOR = new Creator<Trip>() {
        @Override
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        @Override
        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };

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

    public Integer getInfoRating() {
        return infoRating;
    }

    public void setInfoRating(Integer infoRating) {
        this.infoRating = infoRating;
    }

    public Integer getSurfRating() {
        return surfRating;
    }

    public void setSurfRating(Integer surfRating) {
        this.surfRating = surfRating;
    }

    protected Trip(Parcel in) {
        if (in.readByte() == 0) {
            tripID = null;
        } else {
            tripID = in.readInt();
        }
        if (in.readByte() == 0) {
            userID = null;
        } else {
            userID = in.readInt();
        }
        if (in.readByte() == 0){
            infoRating = null;
        }else{
            infoRating = in.readInt();
        }if (in.readByte() == 0){
            surfRating = null;
        }else{
            surfRating = in.readInt();
        }
        dateTime = in.readString();
        locationConditions = in.readParcelable(Location.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (tripID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(tripID);
        }
        if (userID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userID);
        }
        if (surfRating == null){
            dest.writeByte((byte)0);
        }else{
            dest.writeByte((byte) 1);
            dest.writeInt(surfRating);
        }
        if (infoRating == null){
            dest.writeByte((byte)0);
        }else{
            dest.writeByte((byte) 1);
            dest.writeInt(infoRating);
        }

        dest.writeString(dateTime);
        dest.writeParcelable(locationConditions, flags);
    }
}