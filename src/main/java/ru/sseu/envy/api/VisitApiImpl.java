package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.VisitDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.service.VisitService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class VisitApiImpl implements VisitApi {

    private final VisitService service;

    private final PageMapper<VisitDto> pageMapper;

    @Override
    public ResponseEntity<List<VisitDto>> getVisitList(Pageable page) {

        return pageMapper.convert(service.getVisitList(page));
    }

    @Override
    public ResponseEntity<VisitDto> getVisit(UUID uuid) {

        return ResponseEntity.ok(service.getVisit(uuid));
    }

    @Override
    public ResponseEntity<VisitDto> createVisit(VisitDto dto) {

        return ResponseEntity.ok(service.createVisit(dto));
    }

    @Override
    public ResponseEntity<VisitDto> updateVisit(UUID uuid, VisitDto dto) {

        return ResponseEntity.ok(service.updateVisit(uuid, dto));
    }

    @Override
    public ResponseEntity<Void> deleteVisit(UUID uuid) {

        service.deleteVisit(uuid);
        return ResponseEntity.ok().build();
    }
}
