package io.github.cellrepair.service.impl;

import io.github.cellrepair.dto.UsuarioDto;
import io.github.cellrepair.exception.ConflitoException;
import io.github.cellrepair.mapper.UsuarioMapper;
import io.github.cellrepair.model.entity.Usuario;
import io.github.cellrepair.repository.UserRepository;
import io.github.cellrepair.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;


    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(usuarioMapper::toDto);
    }

    @Override
    public Usuario criarUsuarioTecnico(UsuarioDto dto) {
        if (dto == null) {
            throw new ConflitoException("Usuário deve ser informado.");
        }

        if (userRepository.existsByNomeUsuario(dto.nomeUsuario())){
            throw new ConflitoException("Nome de usuário já está em uso.");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(dto.nomeUsuario());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setRole(dto.role());
        usuario.setAtivo(true);

        return userRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuarioTecnico(UsuarioDto dto, Usuario usuario) {

        if (dto == null) {
            return usuario;
        }

        var usuarioExistente = userRepository.findByNomeUsuario(dto.nomeUsuario());

        if (usuarioExistente != null && !usuarioExistente.getUsername().equals(usuario.getUsername())) {
            throw new ConflitoException("Nome de usuário já está em uso.");
        }

        usuario.setNomeUsuario(dto.nomeUsuario());

        if (dto.senha() != null && !dto.senha().isBlank()) {
            usuario.setSenha(passwordEncoder.encode(dto.senha()));
        }

        return userRepository.save(usuario);

    }


}
