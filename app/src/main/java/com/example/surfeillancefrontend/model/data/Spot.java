package com.example.surfeillancefrontend.model.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Spot implements Parcelable {
    private int spotId;
    private String locationName;
    private String tideStationId;

    public Spot(int spotId, String locationName) {
        this.spotId = spotId;
        this.locationName = locationName;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getTideStationId() {
        return tideStationId;
    }

    public void setTideStationId(String tideStationId) {
        this.tideStationId = tideStationId;
    }

    protected Spot(Parcel in) {
        spotId = in.readInt();
        locationName = in.readString();
        tideStationId = in.readString();
    }

    public static final Creator<Spot> CREATOR = new Creator<Spot>() {
        @Override
        public Spot createFromParcel(Parcel in) {
            return new Spot(in);
        }

        @Override
        public Spot[] newArray(int size) {
            return new Spot[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(spotId);
        dest.writeString(locationName);
        dest.writeString(tideStationId);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

