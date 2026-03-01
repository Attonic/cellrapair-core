package io.github.cellrepair.service;

import io.github.cellrepair.dto.OrdemServicoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrdemServicoService {

    Page<OrdemServicoDto> findAll(Pageable pageable);

    OrdemServicoDto findById(Long id);

    OrdemServicoDto save(OrdemServicoDto ordemServicoDto);

    OrdemServicoDto update(OrdemServicoDto ordemServicoDto, Long id);

    OrdemServicoDto updateItemOs(OrdemServicoDto ordemServicoDto, Long id, Long idItemOs);

}
