package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import ru.sseu.envy.dto.ProcedureDto;
import ru.sseu.envy.entity.ProcedureEntity;

@Mapper(componentModel = "spring")
public interface ProcedureMapper {

    ProcedureDto toDto(ProcedureEntity entity);
}
