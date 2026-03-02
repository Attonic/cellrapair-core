package io.github.cellrepair.service;

import io.github.cellrepair.dto.PecaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PecaService {

    PecaDto findById(Long id);

    Page<PecaDto> findAll(Pageable pageable);

    PecaDto save(PecaDto pecaDto);

    PecaDto update(PecaDto pecaDto, Long id);
}
