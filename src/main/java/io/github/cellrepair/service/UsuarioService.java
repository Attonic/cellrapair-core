package io.github.cellrepair.service;

import io.github.cellrepair.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {


    Page<Usuario> findAll(Pageable pageable);


}
