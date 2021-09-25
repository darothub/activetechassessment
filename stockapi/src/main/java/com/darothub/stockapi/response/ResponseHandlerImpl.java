package com.darothub.stockapi.response;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ResponseHandlerImpl implements ResponseHandler {
    private final ResponseModel responseModel;
    @Override
    public ResponseEntity<ResponseModel> handleSuccessResponseEntity(String message, HttpStatus status, Object payload) {
        responseModel.setMessage(message);
        responseModel.setStatus(status.value());
        responseModel.setPayload(payload);
        return new ResponseEntity<>(responseModel, status);
    }

    @Override
    public ResponseEntity<ResponseModel> handleSuccessResponseEntity(String message, HttpStatus status) {
        responseModel.setMessage(message);
        responseModel.setStatus(status.value());
        return new ResponseEntity<>(responseModel, status);
    }
}
