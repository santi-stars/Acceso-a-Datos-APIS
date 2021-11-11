package com.svalero.bikesapi.exception;

public class BikeNotFoundException extends Exception {

    private static final String DEFAULT_ERROR_MESSAGE = "Bike not found";

    public BikeNotFoundException(String message) {  // Constructor con mensaje (más usado)
        super(message);
    }

    public BikeNotFoundException() {    // Constructor sin mensaje
        super(DEFAULT_ERROR_MESSAGE);
    }
}
