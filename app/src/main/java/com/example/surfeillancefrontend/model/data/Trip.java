package com.example.surfeillancefrontend.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Trip implements Parcelable {

    Integer tripID;
    Integer userID;
    String dateTime;
    Float surfRating;
    Float infoRating;

    Double waveHeight;
    String waveDirection;
    Double wavePeriod;
    Double windSpeed;
    String windDirection;
    String gusts;
    String tideHeight;

    public Trip(Integer tripID, Integer userID, String dateTime, Float surfRating, Float infoRating, Location locationConditions, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, String windDirection, String gusts, String tideHeight) {
        this.tripID = tripID;
        this.userID = userID;
        this.dateTime = dateTime;
        this.surfRating = surfRating;
        this.infoRating = infoRating;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.gusts = gusts;
        this.tideHeight = tideHeight;

    }

    public Trip(Integer tripID, Integer userID, String dateTime, Location locationConditions, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, String windDirection, String gusts, String tideHeight) {
        this.tripID = tripID;
        this.userID = userID;
        this.dateTime = dateTime;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.gusts = gusts;
        this.tideHeight = tideHeight;
        this.infoRating = null;
        this.surfRating = null;
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

    public Float getInfoRating() {
        return infoRating;
    }

    public void setInfoRating(Float infoRating) {
        this.infoRating = infoRating;
    }

    public Float getSurfRating() {
        return surfRating;
    }

    public void setSurfRating(Float surfRating) {
        this.surfRating = surfRating;
    }

    public void setTripID(Integer tripID) {
        this.tripID = tripID;
    }

    public Double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(Double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public String getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(String waveDirection) {
        this.waveDirection = waveDirection;
    }

    public Double getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(Double wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getGusts() {
        return gusts;
    }

    public void setGusts(String gusts) {
        this.gusts = gusts;
    }

    public String getTideHeight() {
        return tideHeight;
    }

    public void setTideHeight(String tideHeight) {
        this.tideHeight = tideHeight;
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
        if (in.readByte() == 0) {
            infoRating = null;
        } else {
            infoRating = in.readFloat();
        }
        if (in.readByte() == 0) {
            surfRating = null;
        } else {
            surfRating = in.readFloat();
        }
        if (in.readByte() == 0) {
            waveHeight = null;
        } else {
            waveHeight = in.readDouble();
        }

        if (in.readByte() == 0) {
            wavePeriod = null;
        } else {
            wavePeriod = in.readDouble();
        }
        if (in.readByte() == 0) {
            windSpeed = null;
        } else {
            windSpeed = in.readDouble();
        }

        dateTime = in.readString();
        waveDirection = in.readString();
        windDirection = in.readString();
        gusts = in.readString();
        tideHeight = in.readString();
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
        if (surfRating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(surfRating);
        }
        if (infoRating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(infoRating);
        }
        if (waveHeight == null) {
            dest.writeByte((byte) 0); // indicates null
        } else {
            dest.writeByte((byte) 1); // indicates non-null
            dest.writeDouble(waveHeight);
        }
        dest.writeString(waveDirection);

        if (wavePeriod == null) {
            dest.writeByte((byte) 0); // indicates null
        } else {
            dest.writeByte((byte) 1); // indicates non-null
            dest.writeDouble(wavePeriod);
        }

        if (windSpeed == null) {
            dest.writeByte((byte) 0); // indicates null
        } else {
            dest.writeByte((byte) 1); // indicates non-null
            dest.writeDouble(windSpeed);
        }

        dest.writeString(dateTime);
        dest.writeString(windDirection);
        dest.writeString(gusts);
        dest.writeString(tideHeight);

    }
}