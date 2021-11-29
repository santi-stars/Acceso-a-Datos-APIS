package com.svalero.bikesapi.exception;

public class UserNotFoundException extends Exception {

    private static final String DEFAULT_ERROR_MESSAGE = "User not found";

    public UserNotFoundException(String message) {  // Constructor con mensaje (más usado)
        super(message);
    }

    public UserNotFoundException() {    // Constructor sin mensaje
        super(DEFAULT_ERROR_MESSAGE);
    }
}
