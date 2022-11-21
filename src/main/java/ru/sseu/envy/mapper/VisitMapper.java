package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sseu.envy.dto.VisitDto;
import ru.sseu.envy.entity.VisitEntity;
import ru.sseu.envy.entity.VisitViewEntity;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    @Mapping(target = "visitTime", expression = "java(entity.getVisitTime().atOffset(java.time.ZoneOffset.UTC))")
    VisitDto toDto(VisitEntity entity);
    @Mapping(target = "visitTime", expression = "java(entity.getVisitTime().atOffset(java.time.ZoneOffset.UTC))")
    VisitDto toDto(VisitViewEntity entity);
}
