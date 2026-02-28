package io.github.cellrepair.service.impl;

import io.github.cellrepair.dto.OrdemServicoDto;
import io.github.cellrepair.exception.NenhumResultadoException;
import io.github.cellrepair.mapper.OrdemServicoMapper;
import io.github.cellrepair.model.entity.OrdemServico;
import io.github.cellrepair.model.entity.Usuario;
import io.github.cellrepair.repository.AparelhoRepository;
import io.github.cellrepair.repository.ClienteRepository;
import io.github.cellrepair.repository.OrdemServicoRepository;
import io.github.cellrepair.repository.TecnicoRepository;
import io.github.cellrepair.repository.UserRepository;
import io.github.cellrepair.service.OrdemServicoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdemServicoImpl implements OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final OrdemServicoMapper ordemServicoMapper;
    private final UserRepository userRepository;
    private final AparelhoRepository aparelhoRepository;
    private final TecnicoRepository tecnicoRepository;
    private final ClienteRepository clienteRepository;


    @Override
    public Page<OrdemServicoDto> findAll(Pageable pageable) {
        return ordemServicoRepository.findAll(pageable)
                .map(ordemServicoMapper::toDto);
    }

    @Override
    public OrdemServicoDto findById(Long id) {
        var ordemServico = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new NenhumResultadoException("Ordem de Serviço não encontrada."));

        return ordemServicoMapper.toDto(ordemServico);
    }

    @Override
    public OrdemServicoDto save(OrdemServicoDto ordemServicoDto) {

        var aparelho = aparelhoRepository.findById(ordemServicoDto.getAparelhoId())
                .orElseThrow(() -> new NenhumResultadoException("Aparelho não encontrado."));

        var tencnico = tecnicoRepository.findById(ordemServicoDto.getTecnicoId())
                .orElseThrow(() -> new NenhumResultadoException("Técnico não encontrado."));

        var cliente = clienteRepository.findById(ordemServicoDto.getClienteId())
                .orElseThrow(() -> new NenhumResultadoException("Cliente não encontrado."));

        String loginUsuarioLogado = SecurityContextHolder.getContext().getAuthentication().getName();

        var userDetails = userRepository.findByNomeUsuario(loginUsuarioLogado);
        if (userDetails == null){
            throw new NenhumResultadoException("Usuário não encontrado.");
        }

        Usuario usuarioLogado = (Usuario) userDetails;

        OrdemServico ordemServico = ordemServicoMapper.toEntity(ordemServicoDto);
        ordemServico.setUsuario(usuarioLogado);
        ordemServico.setAparelho(aparelho);
        ordemServico.setCliente(cliente);
        ordemServico.setTecnico(tencnico);

        OrdemServico ordemServicoSalva = ordemServicoRepository.save(ordemServico);
        return ordemServicoMapper.toDto(ordemServicoSalva);
    }

    @Override
    public OrdemServicoDto update(OrdemServicoDto ordemServicoDto, Long id) {

        OrdemServico ordemServicoExistente = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new NenhumResultadoException("Ordem de serviço não encontrada."));

        var aparelho = aparelhoRepository.findById(ordemServicoDto.getAparelhoId())
                .orElseThrow(() -> new NenhumResultadoException("Aparelho não encontrado."));

        var tecnico = tecnicoRepository.findById(ordemServicoDto.getTecnicoId())
                .orElseThrow(() -> new NenhumResultadoException("Técnico não encontrado."));

        var cliente = clienteRepository.findById(ordemServicoDto.getClienteId())
                .orElseThrow(() -> new NenhumResultadoException("Cliente não encontrado."));

        ordemServicoExistente.setImei(ordemServicoDto.getImei());
        ordemServicoExistente.setCor(ordemServicoDto.getCor());
        ordemServicoExistente.setAcessorios(ordemServicoDto.getAcessorios());
        ordemServicoExistente.setSenha(ordemServicoDto.getSenha());
        ordemServicoExistente.setDefeitoRelatado(ordemServicoDto.getDefeitoRelatado());
        ordemServicoExistente.setLaudoTecnico(ordemServicoDto.getLaudoTecnico());
        ordemServicoExistente.setStatus(ordemServicoDto.getStatus());
        ordemServicoExistente.setValorTotal(ordemServicoDto.getValorTotal());

        ordemServicoExistente.setAparelho(aparelho);
        ordemServicoExistente.setCliente(cliente);
        ordemServicoExistente.setTecnico(tecnico);

        OrdemServico ordemServicoAtualizada = ordemServicoRepository.save(ordemServicoExistente);
        return ordemServicoMapper.toDto(ordemServicoAtualizada);

    }
}
