package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.ProcedureDto;
import ru.sseu.envy.entity.ProcedureEntity;
import ru.sseu.envy.mapper.ProcedureMapper;
import ru.sseu.envy.repository.ProcedureRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository repository;

    private final ProcedureMapper mapper;

    @Override
    public Page<ProcedureDto> getProcedureList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }

    @Override
    public ProcedureDto getProcedure(UUID uuid) {

        return mapper.toDto(repository.getEntityByUuid(uuid));
    }

    @Override
    public ProcedureDto createProcedure(ProcedureDto dto) {

        var entity = new ProcedureEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDuration(dto.getDuration());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ProcedureDto updateProcedure(UUID uuid, ProcedureDto dto) {

        var entity = repository.getEntityByUuid(uuid);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDuration(dto.getDuration());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteProcedure(UUID uuid) {

        repository.delete(repository.getEntityByUuid(uuid));
    }
}
