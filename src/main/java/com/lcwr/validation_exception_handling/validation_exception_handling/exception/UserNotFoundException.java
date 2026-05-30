package com.lcwr.validation_exception_handling.validation_exception_handling.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }
}
