package ru.sseu.envy.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.ProcedurePriceDto;

import java.util.List;
import java.util.UUID;
/**
 * API по работе с ценами процедур
 */
@RestController
@RequestMapping(value = "/api/v1/procedure-price", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProcedurePriceApi {

    @GetMapping
    ResponseEntity<List<ProcedurePriceDto>> getProcedurePriceList(Pageable page);

    @GetMapping("{procedurePriceUuid}")
    ResponseEntity<ProcedurePriceDto> getProcedurePrice(@PathVariable UUID procedurePriceUuid);

    @PostMapping("{procedurePriceUuid}")
    ResponseEntity<ProcedurePriceDto> createProcedurePrice(@PathVariable UUID procedurePriceUuid, @RequestBody ProcedurePriceDto dto);

    @PutMapping("{procedurePriceUuid}")
    ResponseEntity<ProcedurePriceDto> updateProcedurePrice(@PathVariable UUID procedurePriceUuid, @RequestBody ProcedurePriceDto dto);

    @DeleteMapping("{procedurePriceUuid}")
    ResponseEntity<Void> deleteProcedurePrice(@PathVariable UUID procedurePriceUuid);
}
