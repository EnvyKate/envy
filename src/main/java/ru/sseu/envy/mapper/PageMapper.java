package ru.sseu.envy.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageMapper<T> implements Converter<Page<T>, ResponseEntity<List<T>>> {

    @Override
    public ResponseEntity<List<T>> convert(Page<T> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-paging-total-count", String.valueOf(page.getTotalElements()));
        headers.add("x-paging-page-count", String.valueOf(page.getTotalPages()));
        headers.add("x-paging-page", String.valueOf(page.getNumber()));
        headers.add("x-paging-page-size", String.valueOf(page.getSize()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(page.toList());
    }
}
