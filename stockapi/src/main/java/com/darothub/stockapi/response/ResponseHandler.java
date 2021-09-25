package com.darothub.stockapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseHandler {
    ResponseEntity<ResponseModel> handleSuccessResponseEntity(String message, HttpStatus status, Object payload);
    ResponseEntity<ResponseModel> handleSuccessResponseEntity(String message, HttpStatus status);
}