package com.example.monolito_to_hexagonal.infrastructure.output.jpa.repository;

import com.example.monolito_to_hexagonal.infrastructure.output.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByIdentificationNumber(Long personNumber);

    void deleteByIdentificationNumber(Long personNumber);

}
