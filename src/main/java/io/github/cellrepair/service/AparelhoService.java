package io.github.cellrepair.service;

import io.github.cellrepair.dto.AparelhoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AparelhoService {

    AparelhoDto findById(Long id);

    Page<AparelhoDto> findAll(Pageable pageable);

    AparelhoDto save(AparelhoDto aparelhoDto);

    AparelhoDto update(AparelhoDto aparelhoDto, Long id);

}
