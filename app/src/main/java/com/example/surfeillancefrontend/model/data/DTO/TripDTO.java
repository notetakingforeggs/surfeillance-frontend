package com.example.surfeillancefrontend.model.data.DTO;

import com.example.surfeillancefrontend.model.data.AppUser;
import com.example.surfeillancefrontend.model.data.Spot;

import java.time.LocalDate;

public class TripDTO {

        private Long tripId;
        private AppUser user;
        private Spot spot;
        private Integer surfRating;
        private Integer infoRating;
        private LocalDate date;
        private Double waveHeight;
        private String waveDirection;
        private Double wavePeriod;
        private Double windSpeed;
        private String windDirection;
        private Integer gusts;
        private Double tideHeight;


        public TripDTO(AppUser user, Spot spot, LocalDate date, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, String windDirection, Integer gusts, Double tideHeight) {
            this.user = user;
            this.spot = spot;
            this.waveHeight = waveHeight;
            this.waveDirection = waveDirection;
            this.wavePeriod = wavePeriod;
            this.windSpeed = windSpeed;
            this.windDirection = windDirection;
            this.gusts = gusts;
            this.tideHeight = tideHeight;
            this.date = date;
        }

        public TripDTO(long id, AppUser user, Spot spot, LocalDate date, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, String windDirection, Integer gusts, Double tideHeight) {
            this.tripId = id;
            this.user = user;
            this.spot = spot;
            this.waveHeight = waveHeight;
            this.waveDirection = waveDirection;
            this.wavePeriod = wavePeriod;
            this.windSpeed = windSpeed;
            this.windDirection = windDirection;
            this.gusts = gusts;
            this.tideHeight = tideHeight;
            this.date = date;
        }

        public Long getTripId() {
            return tripId;
        }

        public void setTripId(Long tripId) {
            this.tripId = tripId;
        }

        public AppUser getUser() {
            return user;
        }

        public void setUser(AppUser user) {
            this.user = user;
        }

        public Spot getSpot() {
            return spot;
        }

        public void setSpot(Spot spot) {
            this.spot = spot;
        }

        public Integer getSurfRating() {
            return surfRating;
        }

        public void setSurfRating(Integer surfRating) {
            this.surfRating = surfRating;
        }

        public Integer getInfoRating() {
            return infoRating;
        }

        public void setInfoRating(Integer infoRating) {
            this.infoRating = infoRating;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
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

        public Integer getGusts() {
            return gusts;
        }

        public void setGusts(Integer gusts) {
            this.gusts = gusts;
        }

        public Double getTideHeight() {
            return tideHeight;
        }

        public void setTideHeight(Double tideHeight) {
            this.tideHeight = tideHeight;
        }
    }

