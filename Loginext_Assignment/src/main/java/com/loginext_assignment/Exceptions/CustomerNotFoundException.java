package com.loginext_assignment.Exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
