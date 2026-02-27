package io.github.cellrepair.controller;

import io.github.cellrepair.dto.DadosListagemUsuario;
import io.github.cellrepair.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService userService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> findAll(
            @PageableDefault(size = 10, sort = "nomeUsuario")Pageable pageable
            ){
        var page = userService.findAll(pageable)
                .map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

}
