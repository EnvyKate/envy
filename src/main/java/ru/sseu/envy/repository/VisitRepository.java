package ru.sseu.envy.repository;

import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.VisitEntity;

import java.util.UUID;

public interface VisitRepository extends BaseRepository<VisitEntity> {


    @Override
    default VisitEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.visit.not_found", uuid.toString())
        );
    }
}
