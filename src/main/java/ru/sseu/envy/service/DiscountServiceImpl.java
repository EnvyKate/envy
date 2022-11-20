package ru.sseu.envy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sseu.envy.dto.DiscountDto;
import ru.sseu.envy.entity.DiscountEntity;
import ru.sseu.envy.mapper.DiscountMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository repository;

    private final DiscountMapper mapper;

    @Override
    public DiscountDto getDiscount(UUID uuid) {

       return mapper.toDto(repository.getEntityByUuid(uuid));
    }

    @Override
    public Page<DiscountDto> getDiscountList(Pageable page) {

        return repository.findAll(page).map(mapper::toDto);
    }

    @Override
    public DiscountDto createDiscount(DiscountDto dto) {

        var entity = new DiscountEntity();
        entity.setPaymentThreshold(dto.getPaymentThreshold());
        entity.setDiscountValue(dto.getDiscountValue());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public DiscountDto updateDiscount(UUID uuid, DiscountDto dto) {

        var entity = repository.getEntityByUuid(uuid);
        entity.setPaymentThreshold(dto.getPaymentThreshold());
        entity.setDiscountValue(dto.getDiscountValue());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteDiscount(UUID uuid) {

        repository.delete(repository.getEntityByUuid(uuid));
    }
}
