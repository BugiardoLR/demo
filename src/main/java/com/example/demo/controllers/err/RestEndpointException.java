package com.example.demo.controllers.err;

import org.springframework.http.HttpStatus;

public class RestEndpointException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public RestEndpointException(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}