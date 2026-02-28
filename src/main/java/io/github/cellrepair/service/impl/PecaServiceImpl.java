package io.github.cellrepair.service.impl;

import io.github.cellrepair.dto.PecaDto;
import io.github.cellrepair.exception.ConflitoException;
import io.github.cellrepair.exception.NenhumResultadoException;
import io.github.cellrepair.mapper.PecaMapper;
import io.github.cellrepair.model.entity.Peca;
import io.github.cellrepair.repository.PecaRepository;
import io.github.cellrepair.service.PecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PecaServiceImpl implements PecaService {

    private final PecaRepository pecaRepository;
    private final PecaMapper pecaMapper;

    @Override
    public PecaDto findById(Long id) {
        var peca = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada."));
        return pecaMapper.toDto(peca);
    }

    @Override
    public Page<PecaDto> findAll(Pageable pageable) {
        return pecaRepository.findAll(pageable)
                .map(pecaMapper::toDto);
    }

    @Override
    @Transactional
    public PecaDto save(PecaDto pecaDto) {
        if (pecaRepository.existsByDescricao(pecaDto.getDescricao())) {
            throw new ConflitoException("Já existe uma peça com essa Descrição.");
        }
        Peca peca = pecaMapper.toEntity(pecaDto);
        Peca pecaSalva = pecaRepository.save(peca);
        return pecaMapper.toDto(pecaSalva);
    }

    @Override
    @Transactional
    public PecaDto update(PecaDto pecaDto, Long id) {
        Peca peca = pecaRepository.findById(id)
                .orElseThrow(() -> new NenhumResultadoException("Peça não encontrada."));

        if (pecaRepository.existsByDescricaoAndIdNot(pecaDto.getDescricao(), id)) {
            throw new ConflitoException("Já existe outra peça com essa Descrição.");
        }

        pecaMapper.updateEntityFromDto(pecaDto, peca);
        var pecaAtualizada = pecaRepository.save(peca);
        return pecaMapper.toDto(pecaAtualizada);
    }
}
