package com.rating.app.converter;

import com.rating.app.entity.Rating;
import com.rating.app.model.RatingDto;

import java.util.ArrayList;
import java.util.List;

public class ApiConverter {

    public static Rating getRatingJpaObject(RatingDto ratingDto) {

        Rating rating = null;
        if (ratingDto != null) {
            rating = new Rating();
            rating.setRatingId(ratingDto.getRatingId());
            rating.setUserId(ratingDto.getUserId());
            rating.setHotelId(ratingDto.getHotelId());
            rating.setFeedBack(ratingDto.getFeedBack());
            rating.setNumbarOfRating(ratingDto.getNumbarOfRating());
        }
        return rating;
    }

    public static RatingDto getRatingDtoObject(Rating rating) {

        RatingDto ratingDto = null;
        if (rating != null) {
            ratingDto = new RatingDto();
            ratingDto.setRatingId(rating.getRatingId());
            ratingDto.setUserId(rating.getUserId());
            ratingDto.setHotelId(rating.getHotelId());
            ratingDto.setFeedBack(rating.getFeedBack());
            ratingDto.setNumbarOfRating(rating.getNumbarOfRating());
        }
        return ratingDto;
    }

    public static List<RatingDto> getRatingDtolListObject(List<Rating> ratingList) {
        List<RatingDto> ratingDtoList = null;
        if(ratingList != null && !ratingList.isEmpty()) {
            ratingDtoList = new ArrayList<>();
            for(Rating rating: ratingList) {

                ratingDtoList.add(getRatingDtoObject(rating));
            }
        }
        return ratingDtoList;
    }
}
