package com.example.monolito_to_hexagonal.infrastructure.configuration;

import com.example.monolito_to_hexagonal.domain.api.IPersonServicePort;
import com.example.monolito_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.monolito_to_hexagonal.domain.spi.IPersonPersistencePort;
import com.example.monolito_to_hexagonal.domain.spi.IPhotoPersistencePort;
import com.example.monolito_to_hexagonal.domain.usecase.PersonUseCase;
import com.example.monolito_to_hexagonal.domain.usecase.PhotoUseCase;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.adapter.PersonJpaAdapter;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.entity.PersonEntity;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.mapper.PersonEntityMapper;
import com.example.monolito_to_hexagonal.infrastructure.output.jpa.repository.IPersonRepository;
import com.example.monolito_to_hexagonal.infrastructure.output.mongodb.adapter.PhotoMongodbAdapter;
import com.example.monolito_to_hexagonal.infrastructure.output.mongodb.mapper.PhotoEntityMapper;
import com.example.monolito_to_hexagonal.infrastructure.output.mongodb.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPersonRepository personRepository;
    private  final PersonEntityMapper personEntityMapper;
    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Bean
    public IPersonPersistencePort personPersistencePort(){
        return new PersonJpaAdapter(personRepository, personEntityMapper);
    }

    @Bean
    public IPersonServicePort personServicePort(){
        return new PersonUseCase(personPersistencePort());
    }

    @Bean
    public IPhotoPersistencePort photoPersistencePort(){
        return new PhotoMongodbAdapter(photoRepository, photoEntityMapper);
    }

    @Bean
    public IPhotoServicePort photoServicePort(){
        return new PhotoUseCase(photoPersistencePort());
    }
}
