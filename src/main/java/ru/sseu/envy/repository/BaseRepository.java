package ru.sseu.envy.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

/**
 * Базовый класс для репозиториев
 */
@NoRepositoryBean
public interface BaseRepository<T> {

    Optional<T> findByUuid(UUID uuid);

    T getEntityByUuid(UUID uuid);
}
