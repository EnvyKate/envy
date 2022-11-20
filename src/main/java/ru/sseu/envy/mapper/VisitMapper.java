package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import ru.sseu.envy.dto.VisitDto;
import ru.sseu.envy.entity.VisitEntity;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    VisitDto toDto(VisitEntity entity);
}
