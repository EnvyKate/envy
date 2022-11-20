package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.ProcedureDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.service.ProcedureService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProcedureApiImpl implements ProcedureApi {

    private final ProcedureService service;

    private final PageMapper<ProcedureDto> pageMapper;

    @Override
    public ResponseEntity<List<ProcedureDto>> getProcedureList(Pageable page) {

        return pageMapper.convert(service.getProcedureList(page));
    }

    @Override
    public ResponseEntity<ProcedureDto> getProcedure(UUID uuid) {

        return ResponseEntity.ok(service.getProcedure(uuid));
    }

    @Override
    public ResponseEntity<ProcedureDto> createProcedure(ProcedureDto dto) {

        return ResponseEntity.ok(service.createProcedure(dto));
    }

    @Override
    public ResponseEntity<ProcedureDto> updateProcedure(UUID uuid, ProcedureDto dto) {

        return ResponseEntity.ok(service.updateProcedure(uuid, dto));
    }

    @Override
    public ResponseEntity<Void> deleteProcedure(UUID uuid) {

        service.deleteProcedure(uuid);
        return ResponseEntity.ok().build();
    }
}
