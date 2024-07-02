package com.example.surfeillancefrontend.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable {
    @SerializedName("name") // This allows GSON to map the key names in the JSON string to the Java object and vice-versa while serialising and deserialising. The String argument the annotation is expecting has to exactly match the key name in the JSON string
    String name;
    @SerializedName("details")
    String details;
    @SerializedName("requestTime")
    String requestTime;
    @SerializedName("latitude")
    String latitude;
    @SerializedName("longitude")
    String longitude;
    @SerializedName("timezone")
    String timezone;
    @SerializedName("waveHeight")
    Double waveHeight;
    @SerializedName("waveDirection")
    String waveDirection;
    @SerializedName("wavePeriod")
    Double wavePeriod;
    @SerializedName("windspeed")
    Double windSpeed;
    @SerializedName("gusts")
    Double gusts;
    @SerializedName("highTideHeight")
    Double highTideHeight;
    @SerializedName("highTideTime")
    String highTideTime;
    @SerializedName("lowTideHeight")
    Double lowTideHeight;
    @SerializedName("lowTideTime")
    String lowTideTime;

    public Location() {
    }

    public Location(String name, String details, String requestTime, String latitude, String longitude, String timezone, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, Double gusts, Double highTideHeight, String highTideTime, Double lowTideHeight, String lowTideTime) {
        this.name = name;
        this.details = details;
        this.requestTime = requestTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.gusts = gusts;
        this.highTideHeight = highTideHeight;
        this.highTideTime = highTideTime;
        this.lowTideHeight = lowTideHeight;
        this.lowTideTime = lowTideTime;
    }

    public Location(String name, String latitude, String longitude, String timezone, String waveDirection) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.waveDirection = waveDirection;
    }

    protected Location(Parcel in) {
        name = in.readString();
        details = in.readString();
        requestTime = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        timezone = in.readString();
        if (in.readByte() == 0) {
            waveHeight = null;
        } else {
            waveHeight = in.readDouble();
        }
        waveDirection = in.readString();
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
        if (in.readByte() == 0) {
            gusts = null;
        } else {
            gusts = in.readDouble();
        }
        if (in.readByte() == 0) {
            highTideHeight = null;
        } else {
            highTideHeight = in.readDouble();
        }
        highTideTime = in.readString();
        if (in.readByte() == 0) {
            lowTideHeight = null;
        } else {
            lowTideHeight = in.readDouble();
        }
        lowTideTime = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    public Double getGusts() {
        return gusts;
    }

    public void setGusts(Double gusts) {
        this.gusts = gusts;
    }

    public Double getHighTideHeight() {
        return highTideHeight;
    }

    public void setHighTideHeight(Double highTideHeight) {
        this.highTideHeight = highTideHeight;
    }

    public String getHighTideTime() {
        return highTideTime;
    }

    public void setHighTideTime(String highTideTime) {
        this.highTideTime = highTideTime;
    }

    public Double getLowTideHeight() {
        return lowTideHeight;
    }

    public void setLowTideHeight(Double lowTideHeight) {
        this.lowTideHeight = lowTideHeight;
    }

    public String getLowTideTime() {
        return lowTideTime;
    }

    public void setLowTideTime(String lowTideTime) {
        this.lowTideTime = lowTideTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(details);
        dest.writeString(requestTime);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(timezone);
        if (waveHeight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(waveHeight);
        }
        dest.writeString(waveDirection);
        if (wavePeriod == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(wavePeriod);
        }
        if (windSpeed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(windSpeed);
        }
        if (gusts == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(gusts);
        }
        if (highTideHeight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(highTideHeight);
        }
        dest.writeString(highTideTime);
        if (lowTideHeight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(lowTideHeight);
        }
        dest.writeString(lowTideTime);
    }
}
