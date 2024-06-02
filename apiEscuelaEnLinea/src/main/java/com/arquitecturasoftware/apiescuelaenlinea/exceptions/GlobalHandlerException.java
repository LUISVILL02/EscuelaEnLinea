package com.arquitecturasoftware.apiescuelaenlinea.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(EntityNoFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNoFoundException(EntityNoFoundException ex, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage()
                , HttpStatus.NOT_FOUND.value()
                , System.currentTimeMillis()
                , request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ErrorResponse> handleEntityExistException(EntityExistException e, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),
                HttpStatus.CONFLICT.value()
                , System.currentTimeMillis()
                , request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
