package io.github.cellrepair.service;

import io.github.cellrepair.dto.AnexoOsDto;
import io.github.cellrepair.model.entity.AnexoOs;

import java.util.List;

public interface AnexoOsService {

    AnexoOsDto findById(Long id);

    List<AnexoOs> findByOrdemServicoId(Long ordemServicoId);
}
