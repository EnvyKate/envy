package ru.sseu.envy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.sseu.envy.dto.StaffCreateDto;
import ru.sseu.envy.dto.StaffDto;
import ru.sseu.envy.dto.StaffUpdateDto;
import ru.sseu.envy.mapper.PageMapper;
import ru.sseu.envy.service.StaffService;

import java.util.List;
import java.util.UUID;


/**
 * Реализация API по работе с персоналом
 */
@Controller
@RequiredArgsConstructor
public class StaffApiImpl implements StaffApi {

    private final StaffService service;

    private final PageMapper<StaffDto> pageMapper;

    @Override
    public ResponseEntity<StaffDto> getStaff(UUID staffUuid) {

        return ResponseEntity.ok(service.getStaff(staffUuid));
    }

    @Override
    public ResponseEntity<List<StaffDto>> getStaffList(Pageable page) {
        return pageMapper.convert(service.getStaffList(page));
    }

    @Override
    public ResponseEntity<StaffDto> createStaff(StaffCreateDto dto) {

        return ResponseEntity.ok(service.createStaff(dto));
    }

    @Override
    public ResponseEntity<StaffDto> updateStaff(UUID staffUuid, StaffUpdateDto dto) {

        return ResponseEntity.ok(service.updateStaff(staffUuid, dto));
    }

    @Override
    public ResponseEntity<Void> deleteStaff(UUID staffUuid) {

        service.deleteStaff(staffUuid);
        return ResponseEntity.ok().build();
    }
}
