package com.loginext_assignment.Exceptions;

public class OrderDetailsNotFoundException extends Exception{
    public OrderDetailsNotFoundException() {
    }

    public OrderDetailsNotFoundException(String message) {
        super(message);
    }
}
