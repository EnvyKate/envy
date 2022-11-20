package ru.sseu.envy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sseu.envy.dto.QualificationDto;

import java.util.UUID;

public interface QualificationService {
    QualificationDto getQualification(UUID uuid);

    Page<QualificationDto> getQualificationList(Pageable page);

    QualificationDto createQualification(QualificationDto dto);

    QualificationDto updateQualification(UUID uuid, QualificationDto dto);

    void deleteQualification(UUID uuid);
}
