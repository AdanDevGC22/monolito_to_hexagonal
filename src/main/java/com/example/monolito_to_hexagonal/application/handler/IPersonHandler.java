package com.example.monolito_to_hexagonal.application.handler;

import com.example.monolito_to_hexagonal.application.dto.PersonRequest;
import com.example.monolito_to_hexagonal.application.dto.PersonResponse;

import java.util.List;

public interface IPersonHandler {

    void savePersonInBD(PersonRequest personRequest);

    List<PersonResponse> getAllPersonFromBD();

    PersonResponse getPersonFromBD(Long personNumber);

    void updatePersonInBD(PersonRequest personRequest);

    void deletePersonFromDB(Long personNumber);
}
