package ru.sseu.envy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sseu.envy.dto.DiscountDto;

import java.util.UUID;

public interface DiscountService {
    DiscountDto getDiscount(UUID uuid);

    Page<DiscountDto> getDiscountList(Pageable page);


    DiscountDto createDiscount(DiscountDto dto);

    DiscountDto updateDiscount(UUID uuid, DiscountDto dto);

    void deleteDiscount(UUID uuid);
}
