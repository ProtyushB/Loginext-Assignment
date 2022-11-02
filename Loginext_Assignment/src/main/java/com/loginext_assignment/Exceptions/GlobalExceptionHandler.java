package com.loginext_assignment.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerNotFoundException customerNotFoundException, WebRequest webRequest){
        
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(customerNotFoundException.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));
        
        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeliveryBoyNotFoundException.class)
    public ResponseEntity<MyErrorDetails> deliveryBoyExceptionHandler(DeliveryBoyNotFoundException deliveryBoyNotFoundException, WebRequest webRequest){

        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(deliveryBoyNotFoundException.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderDetailsNotFoundException.class)
    public ResponseEntity<MyErrorDetails> orderDetailsExceptionHandler(OrderDetailsNotFoundException orderDetailsNotFoundException, WebRequest webRequest){

        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(orderDetailsNotFoundException.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> orderDetailsExceptionHandler(Exception exception, WebRequest webRequest){

        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(exception.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
