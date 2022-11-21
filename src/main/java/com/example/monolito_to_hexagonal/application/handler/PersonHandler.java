package com.example.monolito_to_hexagonal.application.handler;

import com.example.monolito_to_hexagonal.application.dto.PersonRequest;
import com.example.monolito_to_hexagonal.application.dto.PersonResponse;
import com.example.monolito_to_hexagonal.application.mapper.PersonRequestMapper;
import com.example.monolito_to_hexagonal.application.mapper.PersonResponseMapper;
import com.example.monolito_to_hexagonal.domain.api.IPersonServicePort;
import com.example.monolito_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.monolito_to_hexagonal.domain.model.Person;
import com.example.monolito_to_hexagonal.domain.model.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonHandler implements IPersonHandler{

    private final IPersonServicePort personServicePort;
    private final IPhotoServicePort photoServicePort;
    private final PersonRequestMapper personRequestMapper;
    private final PersonResponseMapper personResponseMapper;

    @Override
    public void savePersonInBD(PersonRequest personRequest) {
        Photo photo = photoServicePort.savePhoto(personRequestMapper.toPhoto(personRequest));
        Person person = personRequestMapper.toPerson(personRequest);
        person.setPhotoId(photo.getId());
        personServicePort.savePerson(person);
    }

    @Override
    public List<PersonResponse> getAllPersonFromBD() {
        return personResponseMapper.toResponseList(personServicePort.getAllPerson(), photoServicePort.getAllPhotos());
    }

    @Override
    public PersonResponse getPersonFromBD(Long personNumber) {
        Person person = personServicePort.getPerson(personNumber);
        System.out.println("person -> "+person);
        return personResponseMapper.toResponse(person,photoServicePort.getPhoto(person.getPhotoId()));
    }

    @Override
    public void updatePersonInBD(PersonRequest personRequest) {
        Person oldPerson = personServicePort.getPerson(personRequest.getIdentificationNumber());
        Photo newPhoto =  personRequestMapper.toPhoto(personRequest);
        newPhoto.setId(oldPerson.getPhotoId());
        photoServicePort.updatePhoto(newPhoto);
        Person newPerson = personRequestMapper.toPerson(personRequest);
        newPerson.setId(oldPerson.getId());
        newPerson.setPhotoId(oldPerson.getPhotoId());
        personServicePort.updatePerson(newPerson);
    }

    @Override
    public void deletePersonFromDB(Long personNumber) {
        Person person = personServicePort.getPerson(personNumber);
        photoServicePort.deletePhoto(person.getPhotoId());
        personServicePort.deletePerson(personNumber);
    }
}
