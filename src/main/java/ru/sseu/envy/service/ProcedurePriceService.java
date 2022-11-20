package ru.sseu.envy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sseu.envy.dto.ProcedurePriceDto;

import java.util.UUID;

public interface ProcedurePriceService {
    Page<ProcedurePriceDto> getProcedurePriceList(Pageable page);

    ProcedurePriceDto getProcedurePrice(UUID uuid);

    ProcedurePriceDto createProcedurePrice(UUID uuid, ProcedurePriceDto dto);

    ProcedurePriceDto updateProcedurePrice(UUID uuid, ProcedurePriceDto dto);

    void deleteProcedurePrice(UUID uuid);
}
