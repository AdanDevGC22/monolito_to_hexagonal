package com.example.monolito_to_hexagonal.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

    private String name;
    private String lastName;
    private String idType;
    private Long identificationNumber;
    private String age;
    private String cityOfBirth;
    private String photo;
}
