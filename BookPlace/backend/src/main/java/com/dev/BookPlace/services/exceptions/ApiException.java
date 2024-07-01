package com.dev.BookPlace.services.exceptions;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
