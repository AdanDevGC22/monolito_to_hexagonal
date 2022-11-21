package com.example.monolito_to_hexagonal.domain.usecase;

import com.example.monolito_to_hexagonal.domain.api.IPersonServicePort;
import com.example.monolito_to_hexagonal.domain.model.Person;
import com.example.monolito_to_hexagonal.domain.spi.IPersonPersistencePort;

import java.util.List;

public class PersonUseCase implements IPersonServicePort {

    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public void savePerson(Person person) {
        // aca ponemos las validaciones antes de insertar en bases de datos
        personPersistencePort.savePerson(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personPersistencePort.getAllPerson();
    }

    @Override
    public Person getPerson(Long personNumber) {
        return personPersistencePort.getPerson(personNumber);
    }

    @Override
    public void updatePerson(Person person) {
        personPersistencePort.updatePerson(person);
    }

    @Override
    public void deletePerson(Long personNumber) {
        personPersistencePort.deletePerson(personNumber);
    }
}
