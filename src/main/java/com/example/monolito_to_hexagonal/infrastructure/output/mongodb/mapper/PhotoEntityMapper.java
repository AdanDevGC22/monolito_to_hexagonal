package com.example.monolito_to_hexagonal.infrastructure.output.mongodb.mapper;

import com.example.monolito_to_hexagonal.domain.model.Photo;
import com.example.monolito_to_hexagonal.infrastructure.output.mongodb.entity.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoEntityMapper {

    PhotoEntity toEntity(Photo photo);

    Photo toPhoto(PhotoEntity photoEntity);

    List<Photo> toPhotoList(List<PhotoEntity> photoEntityList);
}
