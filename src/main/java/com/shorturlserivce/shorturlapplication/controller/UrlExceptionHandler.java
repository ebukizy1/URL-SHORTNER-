package com.shorturlserivce.shorturlapplication.controller;

import com.shorturlserivce.shorturlapplication.validation.ErrorResponse;
import com.shorturlserivce.shorturlapplication.validation.UrlErrorResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UrlExceptionHandler {
@ExceptionHandler(UrlErrorResponseException.class)
    public ResponseEntity<ErrorResponse> handleUrlErrorResponseException(UrlErrorResponseException exception){
    ErrorResponse errorResponse = new ErrorResponse(exception.getStatus(), exception.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
}
}
