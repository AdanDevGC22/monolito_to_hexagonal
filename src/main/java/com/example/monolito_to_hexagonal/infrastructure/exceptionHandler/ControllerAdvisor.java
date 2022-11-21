package com.example.monolito_to_hexagonal.infrastructure.exceptionHandler;

import com.example.monolito_to_hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.monolito_to_hexagonal.infrastructure.exception.PersonAlreadyExistsException;
import com.example.monolito_to_hexagonal.infrastructure.exception.PersonNotFoundException;
import com.example.monolito_to_hexagonal.infrastructure.exception.PhotoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlePersonAlreadyExistsException(
            PersonAlreadyExistsException personAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PERSON_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePersonNotFoundException(
            PersonNotFoundException personNotFoundException){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PERSON_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(PhotoNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePhotoNotFoundException(
            PhotoNotFoundException photoNotFoundException){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.PHOTO_NOT_FOUND.getMessage()));
    }
}
