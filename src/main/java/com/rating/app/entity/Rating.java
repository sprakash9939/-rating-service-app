package com.rating.app.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="hotel_id")
    private Integer hotelId;

    @Column(name="numbar_of_rating")
    private Integer numbarOfRating;

    @Column(name="feedBack")
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

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Integer getNumbarOfRating() {
        return numbarOfRating;
    }

    public void setNumbarOfRating(Integer numbarOfRating) {
        this.numbarOfRating = numbarOfRating;
    }
}
