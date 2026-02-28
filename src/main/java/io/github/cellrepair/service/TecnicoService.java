package io.github.cellrepair.service;

import io.github.cellrepair.dto.TecnicoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TecnicoService {

    Page<TecnicoDto> findAll(Pageable pageable);

    TecnicoDto finById(Long id);

    TecnicoDto save(TecnicoDto tecnicoDto);

    TecnicoDto update(TecnicoDto tecnicoDto, Long id);

}
