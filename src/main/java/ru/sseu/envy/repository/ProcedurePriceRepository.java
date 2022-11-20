package ru.sseu.envy.repository;

import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.ProcedurePriceEntity;

import java.util.UUID;

public interface ProcedurePriceRepository extends BaseRepository<ProcedurePriceEntity> {


    @Override
    default ProcedurePriceEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.procedure_price.not_found", uuid.toString())
        );
    }
}
