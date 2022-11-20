package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.QualificationDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.mapper.QualificationMapper;
import ru.sseu.envy.service.QualificationService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class QualificationApiImpl implements QualificationApi {

    private QualificationService service;

    private QualificationMapper mapper;

    private PageMapper<QualificationDto> pageMapper;

    @Override
    public ResponseEntity<QualificationDto> getQualification(UUID uuid) {

        return ResponseEntity.ok(service.getQualification(uuid));
    }

    @Override
    public ResponseEntity<List<QualificationDto>> getQualificationList(Pageable page) {

        return pageMapper.convert(service.getQualificationList(page));
    }

    @Override
    public ResponseEntity<QualificationDto> createQualification(QualificationDto dto) {

        return ResponseEntity.ok(service.createQualification(dto));
    }

    @Override
    public ResponseEntity<QualificationDto> updateQualification(UUID uuid, QualificationDto dto) {

        return ResponseEntity.ok(service.updateQualification(uuid, dto));
    }

    @Override
    public ResponseEntity<Void> deleteQualification(UUID uuid) {

        service.deleteQualification(uuid);
        return ResponseEntity.ok().build();
    }
}
