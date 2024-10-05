package com.rating.app.repository;

import com.rating.app.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    public List<Rating> findAllByUserId(Integer userId);
    public List<Rating> findAllByHotelId(Integer hotelId);
}
