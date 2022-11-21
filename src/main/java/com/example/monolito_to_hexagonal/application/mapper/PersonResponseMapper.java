package com.example.monolito_to_hexagonal.application.mapper;

import com.example.monolito_to_hexagonal.application.dto.PersonResponse;
import com.example.monolito_to_hexagonal.domain.model.Person;
import com.example.monolito_to_hexagonal.domain.model.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonResponseMapper {

    @Mapping(target = "photo", qualifiedByName = "byteArrayToBase64")
    PersonResponse toResponse(Person person, Photo photo);

    @Named("byteArrayToBase64")
    static String byteArrayToBase64(byte[] byteArrayPhoto){
        return Base64.getEncoder().encodeToString(byteArrayPhoto);
    }

    default List<PersonResponse> toResponseList(List<Person> personList, List<Photo> photoList){
        return personList.stream()
                .map(person -> {
                    PersonResponse personResponse = new PersonResponse();
                    personResponse.setName(person.getName());
                    personResponse.setLastName(person.getLastName());
                    personResponse.setIdType(person.getIdType());
                    personResponse.setIdentificationNumber(person.getIdentificationNumber());
                    personResponse.setAge(person.getAge());
                    personResponse.setCityOfBirth(person.getCityOfBirth());
                    personResponse.setPhoto(byteArrayToBase64(photoList.stream().filter(photo ->  photo.getId().equals(person.getPhotoId())).findFirst().orElse(null).getPhoto()));
                    return personResponse;
                }).toList();
    }
}
