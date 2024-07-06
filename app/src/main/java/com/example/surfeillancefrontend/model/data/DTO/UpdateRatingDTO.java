package com.example.surfeillancefrontend.model.data.DTO;

public class UpdateRatingDTO {


    private Integer surfRating;
    private Integer infoRating;

    public UpdateRatingDTO(Float surfRating, Float infoRating) {
        this.surfRating = Math.round(surfRating);
        this.infoRating = Math.round(infoRating);
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
}