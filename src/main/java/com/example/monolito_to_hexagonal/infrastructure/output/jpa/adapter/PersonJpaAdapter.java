package com.example.monolito_to_hexagonal.infrastructure.output.jpa.adapter;

import com.example.monolito_to_hexagonal.domain.model.Person;
import com.example.monolito_to_hexagonal.domain.spi.IPersonPersistencePort;
import com.example.monolito_to_hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.monolito_to_hexagonal.infrastructure.exception.PersonAlreadyExistsException;
import com.example.monolito_to_hexagonal.infrastructure.exception.PersonNotFoundException;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.entity.PersonEntity;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.mapper.PersonEntityMapper;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonJpaAdapter  implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final PersonEntityMapper personEntityMapper;

    @Override
    public void savePerson(Person person) {
        if(personRepository.findByIdentificationNumber(person.getIdentificationNumber()).isPresent()){
            throw new PersonAlreadyExistsException();
        }
        personRepository.save(personEntityMapper.toEntity(person));
    }

    @Override
    public List<Person> getAllPerson() {
        List<PersonEntity> personEntityList = personRepository.findAll();
        if(personEntityList.isEmpty()){
            throw  new NoDataFoundException();
        }
        return personEntityMapper.toPersonList(personEntityList);
    }

    @Override
    public Person getPerson(Long personNumber) {
        return personEntityMapper.toPerson(personRepository.findByIdentificationNumber(personNumber).orElseThrow(PersonNotFoundException::new));
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(personEntityMapper.toEntity(person));
    }

    @Override
    public void deletePerson(Long personNumber) {
        personRepository.deleteByIdentificationNumber(personNumber);
    }
}
