package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.CustomerCreateDto;
import ru.sseu.envy.dto.CustomerDto;
import ru.sseu.envy.dto.CustomerUpdateDto;
import ru.sseu.envy.entity.CustomerEntity;
import ru.sseu.envy.mapper.CustomerMapper;
import ru.sseu.envy.repository.CustomerRepository;

import java.util.UUID;

/**
 * Реализация сервиса по работе с клиентами
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    /**
     * Репозиторий для работы с сущностью "Клиент"
     */
    private final CustomerRepository repository;

    /**
     * Маппер сущности "Клиент"
     */
    private final CustomerMapper mapper;
    @Override
    public CustomerDto getCustomer(UUID customerUuid) {

        return mapper.toDto(repository.getEntityByUuid(customerUuid));
    }

    @Override
    public CustomerDto createCustomer(CustomerCreateDto dto) {

        CustomerEntity entity = new CustomerEntity();

        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CustomerDto updateCustomer(UUID customerUuid, CustomerUpdateDto dto) {

        CustomerEntity entity = repository.getEntityByUuid(customerUuid);

        entity.setName(dto.getName());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteCustomer(UUID customerUuid) {

        CustomerEntity entity = repository.getEntityByUuid(customerUuid);

        repository.delete(entity);
    }

    @Override
    public Page<CustomerDto> getCustomerList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }

}
