package ru.sseu.envy.service;

import ru.sseu.envy.dto.CustomerCreateDto;
import ru.sseu.envy.dto.CustomerDto;
import ru.sseu.envy.dto.CustomerUpdateDto;

import java.util.UUID;

/**
 * Сервис по работе с клиентами
 */
public interface CustomerService {
    /**
     * Получить данные о клиенте
     *
     * @param customerUuid уник. идентификатор клиента
     * @return данные о зарегистрированном клиенте
     */
    CustomerDto getCustomer(UUID customerUuid);

    /**
     * Создать (зарегистрировать) нового клиента
     *
     * @param dto данные о новом клиенте
     * @return зарегистрированный клиент
     */
    CustomerDto createCustomer(CustomerCreateDto dto);

    /**
     * Обновить данные клиента
     *
     * @param customerUuid уник. идентификатор клиента
     * @param dto новые данные
     * @return обновленные данные о клиенте
     */
    CustomerDto updateCustomer(UUID customerUuid, CustomerUpdateDto dto);

    /**
     * Удалить клиента
     *
     * @param customerUuid уник. идентификатор клиента
     */
    void deleteCustomer(UUID customerUuid);
}
