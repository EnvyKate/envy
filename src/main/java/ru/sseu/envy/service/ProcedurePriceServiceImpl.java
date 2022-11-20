package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.ProcedurePriceDto;
import ru.sseu.envy.entity.ProcedurePriceEntity;
import ru.sseu.envy.mapper.ProcedurePriceMapper;
import ru.sseu.envy.repository.ProcedurePriceRepository;
import ru.sseu.envy.repository.ProcedureRepository;
import ru.sseu.envy.repository.QualificationRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProcedurePriceServiceImpl implements ProcedurePriceService {

    private final ProcedurePriceRepository repository;
    private final QualificationRepository qualificationRepository;
    private final ProcedureRepository procedureRepository;
    private final ProcedurePriceMapper mapper;

    @Override
    public Page<ProcedurePriceDto> getProcedurePriceList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }

    @Override
    public ProcedurePriceDto getProcedurePrice(UUID uuid) {

        return mapper.toDto(repository.getEntityByUuid(uuid));
    }

    @Override
    public ProcedurePriceDto createProcedurePrice(UUID uuid, ProcedurePriceDto dto) {

        var entity = new ProcedurePriceEntity();

        entity.setQualification(qualificationRepository.getEntityByUuid(dto.getQualificationUuid()));
        entity.setProcedure(procedureRepository.getEntityByUuid(dto.getProcedureUuid()));
        entity.setPrice(dto.getPrice());
        entity.setDiscountAvailable(dto.isDiscountAvailable());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ProcedurePriceDto updateProcedurePrice(UUID uuid, ProcedurePriceDto dto) {

        var entity = repository.getEntityByUuid(uuid);

        entity.setQualification(qualificationRepository.getEntityByUuid(dto.getQualificationUuid()));
        entity.setProcedure(procedureRepository.getEntityByUuid(dto.getProcedureUuid()));
        entity.setPrice(dto.getPrice());
        entity.setDiscountAvailable(dto.isDiscountAvailable());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteProcedurePrice(UUID uuid) {

        repository.delete(repository.getEntityByUuid(uuid));
    }
}
