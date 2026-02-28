package io.github.cellrepair.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.dto.TecnicoDto;
import io.github.cellrepair.service.TecnicoService;
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
@RequestMapping("/tecnicos")
@RequiredArgsConstructor
public class TecnicoController {

    private final TecnicoService tecnicoService;

    @GetMapping
    public ResponseEntity<Page<TecnicoDto>> buscarTodos(@PageableDefault(size = 10, sort = "nomeTecnico")Pageable pageable){
        var tecnico= tecnicoService.findAll(pageable);
        return ResponseEntity.ok().body(tecnico);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable() Long id){
        var tecnico = tecnicoService.finById(id);
        return ResponseEntity.ok().body(tecnico);
    }

    @PostMapping
    public ResponseEntity cadastrar(
            @RequestBody
            @Validated(TecnicoDto.TecnicoView.TecnicoPost.class)
            @JsonView(TecnicoDto.TecnicoView.TecnicoPost.class)
            TecnicoDto tecnicoDto
            ){
        var tecnico = tecnicoService.save(tecnicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnico);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(
            @PathVariable() Long id,
            @RequestBody
            @Validated(TecnicoDto.TecnicoView.TecnicoPut.class)
            @JsonView(TecnicoDto.TecnicoView.TecnicoPut.class)
            TecnicoDto tecnicoDto
    ){
        var tecnico = tecnicoService.save(tecnicoDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tecnico);
    }



}
