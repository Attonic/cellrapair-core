package io.github.cellrepair.service.impl;

import io.github.cellrepair.dto.TecnicoDto;
import io.github.cellrepair.exception.ConflitoException;
import io.github.cellrepair.exception.NenhumResultadoException;
import io.github.cellrepair.mapper.TecnicoMapper;
import io.github.cellrepair.model.entity.Tecnico;
import io.github.cellrepair.model.entity.Usuario;
import io.github.cellrepair.repository.TecnicoRepository;
import io.github.cellrepair.service.TecnicoService;
import io.github.cellrepair.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TecnicoServiceImpl implements TecnicoService {

    private final TecnicoRepository tecnicoRepository;
    private final TecnicoMapper tecnicoMapper;
    private final UsuarioService usuarioService;

    @Override
    public Page<TecnicoDto> findAll(Pageable pageable) {
        return tecnicoRepository.findAll(pageable)
                .map(tecnicoMapper::toDto);
    }

    @Override
    public TecnicoDto finById(Long id) {
        var tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new NenhumResultadoException("Técnico não encontrado"));
        return tecnicoMapper.toDto(tecnico);
    }

    @Override
    @Transactional
    public TecnicoDto save(TecnicoDto tecnicoDto) {

        if (tecnicoRepository.existsByCpfTecnico(tecnicoDto.getCpfTecnico())){
            throw new ConflitoException("CPF já cadastrado.");
        }

        Usuario usuario = usuarioService
                .criarUsuarioTecnico(tecnicoDto.getUsuario());

        Tecnico tecnico = tecnicoMapper.toEntity(tecnicoDto);
        tecnico.setUsuario(usuario);

        Tecnico tecnicoSalvo = tecnicoRepository.save(tecnico);
        return tecnicoMapper.toDto(tecnicoSalvo);
    }

    @Override
    @Transactional
    public TecnicoDto update(TecnicoDto tecnicoDto, Long id) {

        var tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new NenhumResultadoException("Técnico não encontrado"));

        if (tecnicoRepository.existsByCpfTecnicoAndIdNot(tecnicoDto.getCpfTecnico(), id)){
            throw new ConflitoException("CPF já cadastrado.");
        }

        tecnico.setNomeTecnico(tecnicoDto.getNomeTecnico());
        tecnico.setCpfTecnico(tecnicoDto.getCpfTecnico());
        tecnico.setDataNascimento(tecnicoDto.getDataNascimento());
        tecnico.setEspecialidade(tecnicoDto.getEspecialidade());
        tecnico.setComissao(tecnicoDto.getComissao());
        tecnico.setStatus(tecnicoDto.getStatus());

        usuarioService.atualizarUsuarioTecnico(
                tecnicoDto.getUsuario(),
                tecnico.getUsuario()
        );

        Tecnico tecnicoAtualizado = tecnicoRepository.save(tecnico);

        return tecnicoMapper.toDto(tecnicoAtualizado);
    }
}
