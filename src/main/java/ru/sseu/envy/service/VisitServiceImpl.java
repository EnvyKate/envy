package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.VisitDto;
import ru.sseu.envy.entity.VisitEntity;
import ru.sseu.envy.mapper.VisitMapper;
import ru.sseu.envy.repository.CustomerRepository;
import ru.sseu.envy.repository.ProcedureRepository;
import ru.sseu.envy.repository.StaffRepository;
import ru.sseu.envy.repository.VisitRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository repository;

    private final CustomerRepository customerRepository;

    private final StaffRepository staffRepository;

    private final ProcedureRepository procedureRepository;

    private VisitMapper mapper;

    @Override
    public Page<VisitDto> getVisitList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }

    @Override
    public VisitDto getVisit(UUID uuid) {

        return mapper.toDto(repository.getEntityByUuid(uuid));
    }

    @Override
    public VisitDto createVisit(VisitDto dto) {

        var entity = new VisitEntity();
        entity.setStaff(staffRepository.getEntityByUuid(dto.getStaffUuid()));
        entity.setCustomer(customerRepository.getEntityByUuid(dto.getCustomerUuid()));
        entity.setVisitTime(dto.getVisitTime().toLocalDateTime());
        entity.setProcedure(procedureRepository.getEntityByUuid(dto.getProcedureUuid()));

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public VisitDto updateVisit(UUID uuid, VisitDto dto) {

        var entity = repository.getEntityByUuid(uuid);

        entity.setStaff(staffRepository.getEntityByUuid(dto.getStaffUuid()));
        entity.setCustomer(customerRepository.getEntityByUuid(dto.getCustomerUuid()));
        entity.setVisitTime(dto.getVisitTime().toLocalDateTime());
        entity.setProcedure(procedureRepository.getEntityByUuid(dto.getProcedureUuid()));

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteVisit(UUID uuid) {

        repository.delete(repository.getEntityByUuid(uuid));
    }
}
