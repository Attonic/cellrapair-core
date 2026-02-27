package io.github.cellrepair.service;

import io.github.cellrepair.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

    ClienteDto findById(Long id);

    Page<ClienteDto> findAll(Pageable pageable);

    ClienteDto save(ClienteDto clienteDto);

    ClienteDto update(ClienteDto clienteDto, Long id);


}
