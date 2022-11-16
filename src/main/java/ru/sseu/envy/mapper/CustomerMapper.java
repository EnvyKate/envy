package ru.sseu.envy.mapper;

import org.mapstruct.Mapper;
import ru.sseu.envy.dto.CustomerDto;
import ru.sseu.envy.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity entity);
}
