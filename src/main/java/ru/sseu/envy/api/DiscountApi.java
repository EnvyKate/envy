package ru.sseu.envy.api;


import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.DiscountDto;

import java.util.List;
import java.util.UUID;
/**
 * API по работе со скидками
 */
@RestController
@RequestMapping(value = "/api/v1/discount", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DiscountApi {

    @GetMapping("{discountUuid}")
    ResponseEntity<DiscountDto> getDiscount(@PathVariable UUID discountUuid);

    @GetMapping
    ResponseEntity<List<DiscountDto>> getDiscountList(Pageable page);

    @PostMapping
    ResponseEntity<DiscountDto> createDiscount(@RequestBody DiscountDto dto);

    @PutMapping("{discountUuid}")
    ResponseEntity<DiscountDto> updateDiscount(@PathVariable UUID discountUuid, @RequestBody DiscountDto dto);

    @DeleteMapping("{discountUuid}")
    ResponseEntity<Void> deleteDiscount(@PathVariable UUID discountUuid);
}
