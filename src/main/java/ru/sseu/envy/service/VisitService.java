package ru.sseu.envy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sseu.envy.dto.VisitDto;

import java.util.UUID;

public interface VisitService {

    Page<VisitDto> getVisitList(Pageable page);

    VisitDto getVisit(UUID uuid);

    VisitDto createVisit(VisitDto dto);

    VisitDto updateVisit(UUID uuid, VisitDto dto);

    void deleteVisit(UUID uuid);
}
