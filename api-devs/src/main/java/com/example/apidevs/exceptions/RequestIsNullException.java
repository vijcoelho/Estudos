package com.example.apidevs.exceptions;

public class RequestIsNullException extends RuntimeException {
    public RequestIsNullException() {
        super("Request esta nulo");
    }
}
