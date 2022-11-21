package ru.sseu.envy.repository;

import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.VisitViewEntity;

import java.util.UUID;

public interface VisitViewRepository extends BaseRepository<VisitViewEntity> {

    @Override
    default VisitViewEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.visit.not_found", uuid.toString())
        );
    }
}
