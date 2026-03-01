package io.github.cellrepair.service;

import io.github.cellrepair.dto.ItemOsDto;
import io.github.cellrepair.model.entity.ItemOs;

import java.util.List;

public interface ItemOsService {

    ItemOsDto findById(Long id);

    List<ItemOs> findByOrdemServicoId(Long ordemServicoId);
}
