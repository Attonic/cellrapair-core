package io.github.cellrepair.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.dto.AparelhoDto;
import io.github.cellrepair.service.AparelhoService;
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
@RequestMapping("/aparelhos")
@RequiredArgsConstructor
public class AparelhoController {

    private final AparelhoService aparelhoService;

    @GetMapping
    public ResponseEntity<Page<AparelhoDto>> buscarTodos(
            @PageableDefault(size = 10, sort = "marca")
            Pageable pageable
    ){
        var aparelhos = aparelhoService.findAll(pageable);
        return ResponseEntity.ok().body(aparelhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AparelhoDto> buscarPorId(
            @PathVariable Long id
    ){
        var aparelho = aparelhoService.findById(id);
        return ResponseEntity.ok().body(aparelho);
    }

    @PostMapping
    public ResponseEntity<AparelhoDto> cadastrar(
            @RequestBody
            @JsonView(AparelhoDto.AparelhoView.AparelhoPost.class)
            @Validated(AparelhoDto.AparelhoView.AparelhoPost.class)
            AparelhoDto aparelhoDto
    ){
        var aparelho = aparelhoService.save(aparelhoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aparelho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AparelhoDto> atualziar(
            @PathVariable Long id,
            @RequestBody
            @JsonView(AparelhoDto.AparelhoView.AparelhoPut.class)
            @Validated(AparelhoDto.AparelhoView.AparelhoPut.class)
            AparelhoDto aparelhoDto
    ){
        var aparelho = aparelhoService.save(aparelhoDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(aparelho);
    }

}
