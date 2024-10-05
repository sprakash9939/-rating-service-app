package com.rating.app.service;

import com.rating.app.entity.Rating;
import com.rating.app.model.RatingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RatingService {

        public Rating createRating(Rating rating);
        public Rating updateRating(Rating rating);

        public RatingDto updateByRatingId(Integer ratingId,RatingDto ratingDto);
        public Rating findRatingById(Integer ratingId);
        public List<Rating> findAllRating();
        public boolean deleteRatingById(Integer ratingId);
        public List<Rating> findRatingsByUserId(Integer userId);
        public List<Rating> findRatingsByHotelId(Integer hotelId);
}
