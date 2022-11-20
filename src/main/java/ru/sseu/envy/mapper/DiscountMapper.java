package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import ru.sseu.envy.dto.DiscountDto;
import ru.sseu.envy.entity.DiscountEntity;

@Mapper(componentModel = "spring")
public interface DiscountMapper {

    DiscountDto toDto(DiscountEntity entity);
}
