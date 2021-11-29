package com.svalero.bikesapi.exception;

public class RouteNotFoundException extends Exception {

    private static final String DEFAULT_ERROR_MESSAGE = "Route not found";

    public RouteNotFoundException(String message) {  // Constructor con mensaje (más usado)
        super(message);
    }

    public RouteNotFoundException() {    // Constructor sin mensaje
        super(DEFAULT_ERROR_MESSAGE);
    }
}
