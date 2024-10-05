package com.rating.app.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ErrorResponse {

    String message;
    Integer statusCode;
    LocalDateTime localDate;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }
}
