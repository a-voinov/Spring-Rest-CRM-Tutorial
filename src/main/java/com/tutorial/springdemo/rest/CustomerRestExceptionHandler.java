package com.tutorial.springdemo.rest;

import com.tutorial.springdemo.exception.CustomerErrorResponse;
import com.tutorial.springdemo.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    //Add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex){
        //create CustomerErrorResponse
        CustomerErrorResponse response = new CustomerErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        //return response entity
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //Add an exception handler for any other exceptions
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleOtherExceptions(Exception ex){
        //create CustomerErrorResponse
        CustomerErrorResponse response = new CustomerErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        //return response entity
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
