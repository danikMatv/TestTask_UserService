package com.clearsolutions.demotask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<Object> handleInvalidAgeException(InvalidAgeException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Invalid age", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFound ex){
        ErrorResponse errorResponse = new ErrorResponse("User not found",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyParam.class)
    public ResponseEntity<Object> handleEmptyParamException(EmptyParam ex){
        ErrorResponse errorResponse = new ErrorResponse("Param not found",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
