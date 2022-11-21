package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.ProcedurePriceDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.service.ProcedurePriceService;

import java.util.List;
import java.util.UUID;
/**
 * Реализация API по работе с прайсом процедур
 */
@Controller
@RequiredArgsConstructor
public class ProcedurePriceApiImpl implements ProcedurePriceApi {

    private final ProcedurePriceService service;

    private final PageMapper<ProcedurePriceDto> pageMapper;

    @Override
    public ResponseEntity<List<ProcedurePriceDto>> getProcedurePriceList(Pageable page) {

        return pageMapper.convert(service.getProcedurePriceList(page));
    }

    @Override
    public ResponseEntity<ProcedurePriceDto> getProcedurePrice(UUID uuid) {

        return ResponseEntity.ok(service.getProcedurePrice(uuid));
    }

    @Override
    public ResponseEntity<ProcedurePriceDto> createProcedurePrice(UUID uuid, ProcedurePriceDto dto) {

        return ResponseEntity.ok(service.createProcedurePrice(uuid, dto));
    }

    @Override
    public ResponseEntity<ProcedurePriceDto> updateProcedurePrice(UUID uuid, ProcedurePriceDto dto) {
        return ResponseEntity.ok(service.updateProcedurePrice(uuid, dto));
    }

    @Override
    public ResponseEntity<Void> deleteProcedurePrice(UUID uuid) {

        service.deleteProcedurePrice(uuid);
        return ResponseEntity.ok().build();
    }
}
