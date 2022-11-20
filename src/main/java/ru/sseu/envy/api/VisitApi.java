package ru.sseu.envy.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.VisitDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/visit", produces = MediaType.APPLICATION_JSON_VALUE)
public interface VisitApi {

    @GetMapping
    ResponseEntity<List<VisitDto>> getVisitList(Pageable page);

    @GetMapping("{visitUuid}")
    ResponseEntity<VisitDto> getVisit(@PathVariable UUID visitUuid);

    @PostMapping
    ResponseEntity<VisitDto> createVisit(@RequestBody VisitDto dto);

    @PutMapping("{visitUuid}")
    ResponseEntity<VisitDto> updateVisit(@PathVariable UUID visitUuid, @RequestBody VisitDto dto);

    @DeleteMapping("{visitUuid}")
    ResponseEntity<Void> deleteVisit(@PathVariable UUID visitUuid);
}
