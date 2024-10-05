package com.rating.app.model;

import lombok.Builder;

public class RatingDto {

    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private Integer numbarOfRating;
    private String feedBack;

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getNumbarOfRating() {
        return numbarOfRating;
    }

    public void setNumbarOfRating(Integer numbarOfRating) {
        this.numbarOfRating = numbarOfRating;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
