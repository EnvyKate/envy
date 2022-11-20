package ru.sseu.envy.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.QualificationDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/qualification", produces = MediaType.APPLICATION_JSON_VALUE)
public interface QualificationApi {

    @GetMapping("{qualificationUuid}")
    ResponseEntity<QualificationDto> getQualification(@PathVariable UUID qualificationUuid);

    @GetMapping
    ResponseEntity<List<QualificationDto>> getQualificationList(Pageable page);

    @PostMapping
    ResponseEntity<QualificationDto> createQualification(@RequestBody QualificationDto dto);

    @PutMapping("{qualificationUuid}")
    ResponseEntity<QualificationDto> updateQualification(@PathVariable UUID qualificationUuid, @RequestBody QualificationDto dto);

    @DeleteMapping("{qualificationUuid}")
    ResponseEntity<Void> deleteQualification(@PathVariable UUID qualificationUuid);
}
