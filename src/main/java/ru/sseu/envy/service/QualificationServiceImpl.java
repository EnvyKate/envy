package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.QualificationDto;
import ru.sseu.envy.entity.QualificationEntity;
import ru.sseu.envy.mapper.QualificationMapper;
import ru.sseu.envy.repository.QualificationRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QualificationServiceImpl implements QualificationService {

    private final QualificationRepository repository;

    private final QualificationMapper mapper;

    @Override
    public QualificationDto getQualification(UUID uuid) {

        return mapper.toDto(repository.getEntityByUuid(uuid));
    }

    @Override
    public Page<QualificationDto> getQualificationList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }

    @Override
    public QualificationDto createQualification(QualificationDto dto) {

        var entity = new QualificationEntity();
        entity.setName(dto.getName());
        entity.setSalaryRate(dto.getSalaryRate());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public QualificationDto updateQualification(UUID uuid, QualificationDto dto) {

        var entity = repository.getEntityByUuid(uuid);
        entity.setSalaryRate(dto.getSalaryRate());
        entity.setName(dto.getName());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteQualification(UUID uuid) {

        repository.delete(repository.getEntityByUuid(uuid));
    }
}
