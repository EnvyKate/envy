package ru.sseu.envy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sseu.envy.dto.ProcedureDto;

import java.util.UUID;

public interface ProcedureService {
    Page<ProcedureDto> getProcedureList(Pageable page);

    ProcedureDto getProcedure(UUID uuid);

    ProcedureDto createProcedure(ProcedureDto dto);

    ProcedureDto updateProcedure(UUID uuid, ProcedureDto dto);

    void deleteProcedure(UUID uuid);
}
