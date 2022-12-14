package ru.sseu.envy.repository;

import org.hibernate.ObjectNotFoundException;
import ru.sseu.envy.entity.StaffEntity;

import java.util.UUID;

/**
 * Репозиторий сушности "Персонал"
 */
public interface StaffRepository extends BaseRepository<StaffEntity> {

    @Override
    default StaffEntity getEntityByUuid(UUID uuid) {
        return findByUuid(uuid).orElseThrow(
                () -> new ObjectNotFoundException("error.staff.not_found", uuid.toString())
        );
    }
}
