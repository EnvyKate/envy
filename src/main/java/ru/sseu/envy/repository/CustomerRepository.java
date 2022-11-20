package ru.sseu.envy.repository;


import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.CustomerEntity;

import java.util.UUID;

public interface CustomerRepository extends BaseRepository<CustomerEntity> {

    @Override
    default CustomerEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.customer.not_found", uuid.toString())
        );
    }

}
