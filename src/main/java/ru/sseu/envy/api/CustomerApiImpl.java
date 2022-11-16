package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.CustomerCreateDto;
import ru.sseu.envy.dto.CustomerDto;
import ru.sseu.envy.dto.CustomerUpdateDto;
import ru.sseu.envy.service.CustomerService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CustomerApiImpl implements CustomerApi {

    private final CustomerService service;

    @Override
    public ResponseEntity<CustomerDto> getCustomer(UUID customerUuid) {
        return ResponseEntity.ok(service.getCustomer(customerUuid));
    }

    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerCreateDto dto) {
        return ResponseEntity.ok(service.createCustomer(dto));
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(UUID customerUuid, CustomerUpdateDto dto) {
        return ResponseEntity.ok(service.updateCustomer(customerUuid, dto));
    }

    @Override
    public ResponseEntity<CustomerDto> deleteCustomer(UUID customerUuid) {

        service.deleteCustomer(customerUuid);
        return ResponseEntity.ok().build();
    }
}
