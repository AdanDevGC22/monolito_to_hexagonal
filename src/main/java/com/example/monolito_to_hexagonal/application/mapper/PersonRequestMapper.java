package com.example.monolito_to_hexagonal.application.mapper;

import com.example.monolito_to_hexagonal.application.dto.PersonRequest;
import com.example.monolito_to_hexagonal.domain.model.Person;
import com.example.monolito_to_hexagonal.domain.model.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Base64;

@Mapper(componentModel = "spring",
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonRequestMapper {

    Person toPerson(PersonRequest personRequest);

    @Mapping(target = "photo", qualifiedByName = "base64ToByteArray")
    Photo toPhoto(PersonRequest personRequest);// aca convertimos la imagen a un arreglo de bytes

    @Named("base64ToByteArray")
    static byte[] base64ToByteArray(String base64Photo){
        return Base64.getDecoder().decode(base64Photo);
    }
}
