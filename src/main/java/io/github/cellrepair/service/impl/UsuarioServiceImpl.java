package io.github.cellrepair.service.impl;

import io.github.cellrepair.model.entity.Usuario;
import io.github.cellrepair.repository.UserRepository;
import io.github.cellrepair.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository repository;

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
