package com.sergeynik.tasklist.converter;

import com.sergeynik.tasklist.dto.PageDto;
import com.sergeynik.tasklist.dto.PageInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PageDtoConverter {

    public <T, R> PageDto<R> fromDomain(Page<T> page, Function<T, R> entityMapper) {
        List<R> data = page.stream().map(entityMapper).collect(Collectors.toList());
        return new PageDto<>(
            data,
            new PageInfoDto(
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber()
            )
        );
    }
}
