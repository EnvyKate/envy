package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.DiscountDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.service.DiscountService;

import java.util.List;
import java.util.UUID;
/**
 * Реализация API по работе со скидками
 */
@Controller
@RequiredArgsConstructor
public class DiscountApiImpl implements DiscountApi {

    private final DiscountService service;

    private final PageMapper<DiscountDto> pageMapper;

    @Override
    public ResponseEntity<DiscountDto> getDiscount(UUID uuid) {

        return ResponseEntity.ok(service.getDiscount(uuid));
    }

    @Override
    public ResponseEntity<List<DiscountDto>> getDiscountList(Pageable page) {

        return pageMapper.convert(service.getDiscountList(page));
    }

    @Override
    public ResponseEntity<DiscountDto> createDiscount(DiscountDto dto) {

        return ResponseEntity.ok(service.createDiscount(dto));
    }

    @Override
    public ResponseEntity<DiscountDto> updateDiscount(UUID uuid, DiscountDto dto) {

        return ResponseEntity.ok(service.updateDiscount(uuid, dto));
    }

    @Override
    public ResponseEntity<Void> deleteDiscount(UUID uuid) {

        service.deleteDiscount(uuid);
        return ResponseEntity.ok().build();
    }
}
