package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.StaffCreateDto;
import ru.sseu.envy.dto.StaffDto;
import ru.sseu.envy.dto.StaffUpdateDto;
import ru.sseu.envy.entity.StaffEntity;
import ru.sseu.envy.mapper.StaffMapper;
import ru.sseu.envy.repository.QualificationRepository;
import ru.sseu.envy.repository.StaffRepository;

import java.util.UUID;

/**
 * Реализация сервиса по работе с Персоналом
 */
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository repository;

    private final QualificationRepository qualificationRepository;

    private final StaffMapper mapper;

    @Override
    public StaffDto getStaff(UUID staffUuid) {
        return mapper.toDto(repository.getEntityByUuid(staffUuid));
    }

    @Override
    public StaffDto createStaff(StaffCreateDto dto) {

        StaffEntity entity = new StaffEntity();

        entity.setName(dto.getName());
        entity.setHireDate(dto.getHireDate().toLocalDate());
        entity.setQualification(qualificationRepository.getEntityByUuid(dto.getQualificationUuid()));
        StaffEntity savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public StaffDto updateStaff(UUID staffUuid, StaffUpdateDto dto) {

        StaffEntity entity = repository.getEntityByUuid(staffUuid);

        entity.setName(dto.getName());
        entity.setQualification(qualificationRepository.getEntityByUuid(dto.getQualificationUuid()));

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteStaff(UUID staffUuid) {

        StaffEntity entity = repository.getEntityByUuid(staffUuid);

        repository.delete(entity);
    }

    @Override
    public Page<StaffDto> getStaffList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }
}
