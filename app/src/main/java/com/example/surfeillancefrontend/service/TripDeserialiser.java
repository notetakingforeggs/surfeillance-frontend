package com.example.surfeillancefrontend.service;

import android.os.Build;
import com.example.surfeillancefrontend.model.data.Trip;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class TripDeserialiser implements JsonDeserializer<Trip> {
    @Override
    public Trip deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject appUserJson = jsonObject.getAsJsonObject("appUserDTO");
        JsonObject spotJson = jsonObject.getAsJsonObject("spot");

        Trip trip = new Trip();

        trip.setTripID(jsonObject.get("tripId").getAsLong());
        trip.setUserID(appUserJson.get("id").getAsInt());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            trip.setDateTime(LocalDateTime.now().toString());
        }
        trip.setSurfRating(jsonObject.get("surfRating").getAsFloat());
        trip.setInfoRating(jsonObject.get("infoRating").getAsFloat());
        trip.setLocationName(spotJson.get("locationName").getAsString());
        trip.setWaveDirection(jsonObject.get("waveDirection").getAsString());
        trip.setWaveHeight(jsonObject.get("waveHeight").getAsDouble());
        trip.setWavePeriod(jsonObject.get("wavePeriod").getAsDouble());
        trip.setWindSpeed(jsonObject.get("windSpeed").getAsDouble());
        trip.setWindDirection(jsonObject.get("windDirection").getAsString());
        trip.setGusts(jsonObject.get("gusts").getAsString());
        trip.setTideHeight(jsonObject.get("tideHeight").getAsString());

        return trip;
    }
}
