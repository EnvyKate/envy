package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import ru.sseu.envy.dto.ProcedurePriceDto;
import ru.sseu.envy.entity.ProcedurePriceEntity;

@Mapper(componentModel = "spring")
public interface ProcedurePriceMapper {

    ProcedurePriceDto toDto(ProcedurePriceEntity entity);
}
