package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.CustomerCreateDto;
import ru.sseu.envy.dto.CustomerDto;
import ru.sseu.envy.dto.CustomerUpdateDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.service.CustomerService;

import java.util.List;
import java.util.UUID;

/**
 * Реализация API по работе с клинтами
 */
@Controller
@RequiredArgsConstructor
public class CustomerApiImpl implements CustomerApi {

    private final CustomerService service;

    private final PageMapper<CustomerDto> pageMapper;

    @Override
    public ResponseEntity<CustomerDto> getCustomer(UUID customerUuid) {
        return ResponseEntity.ok(service.getCustomer(customerUuid));
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getCustomerList(Pageable page) {
        return pageMapper.convert(service.getCustomerList(page));
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
