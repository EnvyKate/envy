package ru.sseu.envy.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.ProcedureDto;

import java.util.List;
import java.util.UUID;
/**
 * API по работе с процедурами
 */
@RestController
@RequestMapping(value = "/api/v1/procedure", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProcedureApi {

    @GetMapping
    ResponseEntity<List<ProcedureDto>> getProcedureList(Pageable page);

    @GetMapping("{procedureUuid}")
    ResponseEntity<ProcedureDto> getProcedure(@PathVariable UUID procedureUuid);

    @PostMapping
    ResponseEntity<ProcedureDto> createProcedure(@RequestBody ProcedureDto dto);

    @PutMapping("{procedureUuid}")
    ResponseEntity<ProcedureDto> updateProcedure(@PathVariable UUID procedureUuid, @RequestBody ProcedureDto dto);

    @DeleteMapping("{procedureUuid}")
    ResponseEntity<Void> deleteProcedure(@PathVariable UUID procedureUuid);

}
