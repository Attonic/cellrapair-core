package io.github.cellrepair.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.dto.PecaDto;
import io.github.cellrepair.service.PecaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pecas")
@RequiredArgsConstructor
public class PecaController {

    private final PecaService pecaService;

    @GetMapping
    public ResponseEntity<Page<PecaDto>> listarTodos(
            @PageableDefault(size = 10, sort = "descricao") Pageable pageable
    ) {
        var pecas = pecaService.findAll(pageable);
        return ResponseEntity.ok(pecas);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        var peca = pecaService.findById(id);
        return ResponseEntity.ok(peca);
    }

    @PostMapping
    public ResponseEntity cadastrar(
            @RequestBody
            @Validated(PecaDto.PecaView.PecaPost.class)
            @JsonView(PecaDto.PecaView.PecaPost.class)
            PecaDto pecaDto
    ) {
        var pecaSalva = pecaService.save(pecaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pecaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PecaDto> atualizar(
            @PathVariable Long id,
            @RequestBody
            @Validated(PecaDto.PecaView.PecaPut.class)
            @JsonView(PecaDto.PecaView.PecaPut.class)
            PecaDto pecaDto
    ){
        var pecaAtualizada = pecaService.update(pecaDto, id);
        return ResponseEntity.ok(pecaAtualizada);
    }
}
