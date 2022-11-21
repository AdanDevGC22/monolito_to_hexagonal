package com.example.monolito_to_hexagonal.infrastructure.output.mongodb.repository;

import com.example.monolito_to_hexagonal.infrastructure.output.mongodb.entity.PhotoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPhotoRepository  extends MongoRepository<PhotoEntity, String> {
}
