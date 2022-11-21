package com.example.monolito_to_hexagonal.infrastructure.exceptionHandler;

public enum ExceptionResponse {
    PERSON_NOT_FOUND("No Person was found with that identificationNumber"),
    PERSON_ALREADY_EXISTS("there is already a person with that identificationNumber"),
    NO_DATA_FOUND("No data found for the request petition"),
    PHOTO_NOT_FOUND("No photo was found for a person");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
