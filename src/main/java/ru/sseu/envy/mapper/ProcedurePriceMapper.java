package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sseu.envy.dto.ProcedurePriceDto;
import ru.sseu.envy.entity.ProcedurePriceEntity;

@Mapper(componentModel = "spring")
public interface ProcedurePriceMapper {

    @Mapping(target = "procedureUuid", source = "procedure.uuid")
    @Mapping(target = "procedureName", source = "procedure.name")
    @Mapping(target = "qualificationUuid", source = "qualification.uuid")
    @Mapping(target = "qualificationName", source = "qualification.name")
    ProcedurePriceDto toDto(ProcedurePriceEntity entity);
}
