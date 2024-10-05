package com.rating.app.controller;

import com.rating.app.converter.ApiConverter;
import com.rating.app.entity.Rating;
import com.rating.app.model.RatingDto;
import com.rating.app.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping(value = "save-rating")
    public ResponseEntity<?> saveRating(@RequestBody RatingDto ratingDto){
            Rating rating=ApiConverter.getRatingJpaObject(ratingDto);
            ratingService.createRating(rating);
            return ResponseEntity.ok("Rating saved succesfully");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateRating(@RequestBody RatingDto ratingDto){
        Rating rating=ApiConverter.getRatingJpaObject(ratingDto);
        RatingDto result=ApiConverter.getRatingDtoObject(ratingService.updateRating(rating));
        return ResponseEntity.ok(result);
    }
    @GetMapping(value = "/find-by-rating-id/{ratingId}")
    public ResponseEntity<?> getRatingById(@PathVariable(name = "ratingId") Integer ratingId){
        Rating rating=ratingService.findRatingById(ratingId);
        RatingDto ratingDto=ApiConverter.getRatingDtoObject(rating);
        return ResponseEntity.ok(ratingDto);
    }

    @PutMapping(value = "/update-by-rating-id/{ratingId}")
    public ResponseEntity<?> updateByRatingId(@PathVariable(name = "ratingId") Integer ratingId,@RequestBody RatingDto ratingDto){
        RatingDto ratingDtoResult=ratingService.updateByRatingId(ratingId,ratingDto);
        return  ResponseEntity.ok(ratingDtoResult);
    }

    @GetMapping()
    public ResponseEntity<?> getAllRating(){
        List<Rating> ratingList= ratingService.findAllRating();
        List<RatingDto> ratingDtoList=ApiConverter.getRatingDtolListObject(ratingList);
        return ResponseEntity.ok(ratingDtoList);
    }

    @GetMapping(value = "/find-by-user-id/{userId}")
    public ResponseEntity<?> getRatingsByUserId(@PathVariable(name = "userId") Integer userId){
        List<Rating> ratingList=ratingService.findRatingsByUserId(userId);
        List<RatingDto> ratingDtoList=ApiConverter.getRatingDtolListObject(ratingList);
        return ResponseEntity.ok(ratingDtoList);
    }

    @GetMapping(value = "/find-by-hotel-id/{hotelId}")
    public ResponseEntity<?> getRatingsByHotelId(@PathVariable(name = "hotelId") Integer hotelId){
        List<Rating> ratingList=ratingService.findRatingsByHotelId(hotelId);
        List<RatingDto> ratingDtoList=ApiConverter.getRatingDtolListObject(ratingList);
        return ResponseEntity.ok(ratingDtoList);
    }

    @DeleteMapping(value = "/delete-by-rating-id/{ratingId}")
    public ResponseEntity<?> deleteByRatingId(@PathVariable(name = "ratingId") Integer ratingId){
        Boolean isDeleted=ratingService.deleteRatingById(ratingId);
        if(isDeleted==true){
            return ResponseEntity.ok("Record deleted successfully for Rating id: "+ratingId);
        }else {
            return ResponseEntity.ok("No Record found for delete Rating id: "+ratingId);
        }
    }

}
