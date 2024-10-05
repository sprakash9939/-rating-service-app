package com.rating.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobleExceptionHandler {

    ErrorResponse errorResponse;
    @ExceptionHandler
    public ResponseEntity<?> handleRatingException(RatingException ratingException){
        errorResponse=new ErrorResponse();
        errorResponse.setMessage(ratingException.getMessage());
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setLocalDate(LocalDateTime.now());
        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleGlobleException(Exception exception){
        errorResponse=new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setLocalDate(LocalDateTime.now());
        return ResponseEntity.ok(errorResponse);
    }
}
