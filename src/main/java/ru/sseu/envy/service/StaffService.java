package ru.sseu.envy.service;

import ru.sseu.envy.dto.StaffCreateDto;
import ru.sseu.envy.dto.StaffDto;
import ru.sseu.envy.dto.StaffUpdateDto;

import java.util.UUID;

public interface StaffService {

    /**
     * Вернуть представление о персонале по заданному UUID
     * @param staffUuid уник. идентификатор персонала
     * @return представление о персонале
     */
    StaffDto getStaff(UUID staffUuid);

    /**
     * Создать новую сущность Персонала
     *
     * @param dto параметры нового персонала
     * @return представление о созданном персонале
     */
    StaffDto createStaff(StaffCreateDto dto);

    /**
     * Обновить данные о персонале
     *
     * @param staffUuid уник. идентификатор существующей записи Персонала
     * @param dto данные для обновления
     * @return представление об обновленном Персонале
     */
    StaffDto updateStaff(UUID staffUuid, StaffUpdateDto dto);

    /**
     * Удалить персонал
     *
     * @param staffUuid уник. идентификатор персонала
     */
    void deleteStaff(UUID staffUuid);
}
