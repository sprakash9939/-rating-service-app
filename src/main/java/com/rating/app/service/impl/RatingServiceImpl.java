package com.rating.app.service.impl;

import com.rating.app.converter.ApiConverter;
import com.rating.app.entity.Rating;
import com.rating.app.model.RatingDto;
import com.rating.app.repository.RatingRepository;
import com.rating.app.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public RatingDto updateByRatingId(Integer ratingId, RatingDto ratingDto) {

        if(ratingId!=null){
            var ratingEntity=ratingRepository.findById(ratingId).orElseThrow(()->new NoSuchElementException("Record not availble for rating id: "+ratingId));
            modelMapper.map(ratingDto,ratingEntity);
            var result=ratingRepository.save(ratingEntity);
            return modelMapper.map(result,RatingDto.class);
        }
        return null;
    }

    @Override
    public Rating findRatingById(Integer ratingId) {
        Optional<Rating> rating=ratingRepository.findById(ratingId);
        if(rating.isPresent()){
            return rating.get();
        }
        return null;
    }

    @Override
    public List<Rating> findAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public boolean deleteRatingById(Integer ratingId) {
        ratingRepository.deleteById(ratingId);
        return true;
    }

    @Override
    public List<Rating> findRatingsByUserId(Integer userId) {
        return ratingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Rating> findRatingsByHotelId(Integer hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }
}
