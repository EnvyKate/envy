package ru.sseu.envy.repository;

import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.QualificationEntity;

import java.util.UUID;

public interface QualificationRepository extends BaseRepository<QualificationEntity> {

    @Override
    default QualificationEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.qualification.not_found", uuid.toString())
        );
    }
}
