package com.example.monolito_to_hexagonal.domain.api;

import com.example.monolito_to_hexagonal.domain.model.Person;

import java.util.List;

public interface IPersonServicePort {

    void savePerson(Person person);

    List<Person> getAllPerson();

    Person getPerson(Long personNumber);

    void updatePerson(Person person);

    void deletePerson(Long personNumber);
}
