package ru.sseu.envy.api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.StaffCreateDto;
import ru.sseu.envy.dto.StaffDto;
import ru.sseu.envy.dto.StaffUpdateDto;

import java.util.UUID;

/**
 * API по работе с Персоналом
 */
@RestController
@RequestMapping(value = "/api/v1/staff", produces = MediaType.APPLICATION_JSON_VALUE)
public interface StaffApi {

    @GetMapping("{staffUuid}")
    ResponseEntity<StaffDto> getStaff(@PathVariable UUID staffUuid);

    @PostMapping
    ResponseEntity<StaffDto> createStaff(@RequestBody StaffCreateDto dto);

    @PutMapping("{staffUuid}")
    ResponseEntity<StaffDto> updateStaff(@PathVariable UUID staffUuid, @RequestBody StaffUpdateDto dto);

    @DeleteMapping("{staffUuid}")
    ResponseEntity<Void> deleteStaff(@PathVariable UUID staffUuid);

}
