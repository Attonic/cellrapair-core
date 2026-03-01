package io.github.cellrepair.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.dto.ItemOsDto;
import io.github.cellrepair.dto.OrdemServicoDto;
import io.github.cellrepair.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordens-servicos")
@RequiredArgsConstructor
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    @GetMapping
    public ResponseEntity<Page<OrdemServicoDto>> buscarPorTodos(
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        var ordensServicos = ordemServicoService.findAll(pageable);
        return ResponseEntity.ok().body(ordensServicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoDto> buscarPorId(@PathVariable Long id) {
        var ordemServico = ordemServicoService.findById(id);
        return ResponseEntity.ok().body(ordemServico);
    }


    @PostMapping
    public ResponseEntity<OrdemServicoDto> cadastrar(
            @RequestBody
            @JsonView(OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class)
            @Validated(OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class)
            OrdemServicoDto ordemServicoDto
    ) {
        var ordemServico = ordemServicoService.save(ordemServicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoDto> atualizar(
            @PathVariable Long id,
            @RequestBody
            @JsonView(OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class)
            @Validated(OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class)
            OrdemServicoDto ordemServicoDto
    ) {
        var ordemServico = ordemServicoService.update(ordemServicoDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ordemServico);
    }

}
