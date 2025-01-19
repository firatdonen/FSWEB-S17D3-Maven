package com.workintech.zoo.exceptions;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ZooGlobalExceptionHandler {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ZooGlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(ZooException ex) {
        ZooErrorResponse response = new ZooErrorResponse(

                ex.getHttpStatus().value(),
                ex.getMessage(),
                System.currentTimeMillis());
        log.error(response.getMessage());
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(Exception ex) {
        ZooErrorResponse response = new ZooErrorResponse(

                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                System.currentTimeMillis()

        );
        log.error(response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
