package ru.sseu.envy.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sseu.envy.dto.CustomerCreateDto;
import ru.sseu.envy.dto.CustomerDto;
import ru.sseu.envy.dto.CustomerUpdateDto;

import java.util.List;
import java.util.UUID;
/**
 * API по работе с Клиентами
 */
@RestController
@RequestMapping(value = "/api/v1/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public interface CustomerApi {

    @GetMapping("{customerUuid}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerUuid);

    @GetMapping
    ResponseEntity<List<CustomerDto>> getCustomerList(Pageable page);

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerCreateDto dto);

    @PutMapping("{customerUuid}")
    ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID customerUuid, @RequestBody CustomerUpdateDto dto);

    @DeleteMapping("{customerUuid}")
    ResponseEntity<CustomerDto> deleteCustomer(@PathVariable UUID customerUuid);
}
