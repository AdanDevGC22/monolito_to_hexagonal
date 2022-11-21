package com.example.monolito_to_hexagonal.domain.spi;

import com.example.monolito_to_hexagonal.domain.model.Person;

import java.util.List;

public interface IPersonPersistencePort {

    void savePerson(Person person);

    List<Person> getAllPerson();

    Person getPerson(Long personNumber);

    void updatePerson(Person person);

    void  deletePerson(Long personNumber);
}
