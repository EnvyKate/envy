package ru.sseu.envy.repository;

import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.ProcedureEntity;

import java.util.UUID;

public interface ProcedureRepository extends BaseRepository<ProcedureEntity> {

    @Override
    default ProcedureEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.procedure.not_found", uuid.toString())
        );
    }

}
