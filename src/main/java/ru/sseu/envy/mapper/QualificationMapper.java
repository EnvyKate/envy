package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import ru.sseu.envy.dto.QualificationDto;
import ru.sseu.envy.entity.QualificationEntity;

@Mapper(componentModel = "spring")
public interface QualificationMapper {

    QualificationDto toDto(QualificationEntity entity);
}
