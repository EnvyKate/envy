package ru.sseu.envy.mapper;

import org.mapstruct.Mapping;
import ru.sseu.envy.dto.StaffDto;
import ru.sseu.envy.entity.StaffEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    @Mapping(target = "hireDate", expression = "java(entity.getHireDate().atStartOfDay().atOffset(java.time.ZoneOffset.UTC))")
    StaffDto toDto(StaffEntity entity);
}
