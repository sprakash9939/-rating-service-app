package com.rating.app.exception;

public class RatingException extends Exception{

    String message;

    public RatingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
