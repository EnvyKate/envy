package ru.sseu.envy.service;


import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.DiscountEntity;
import ru.sseu.envy.repository.BaseRepository;

import java.util.UUID;

public interface DiscountRepository extends BaseRepository<DiscountEntity> {

    @Override
    default DiscountEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.discount.not_found", uuid.toString())
        );
    }
}
