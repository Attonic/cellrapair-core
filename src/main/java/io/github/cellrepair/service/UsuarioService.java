package io.github.cellrepair.service;

import io.github.cellrepair.dto.TecnicoDto;
import io.github.cellrepair.dto.UsuarioDto;
import io.github.cellrepair.model.entity.Tecnico;
import io.github.cellrepair.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {


    Page<UsuarioDto> findAll(Pageable pageable);

    Usuario criarUsuarioTecnico(UsuarioDto dto);

    Usuario atualizarUsuarioTecnico(UsuarioDto dto, Usuario usuario);


}
