package io.github.cellrepair.controller;

import io.github.cellrepair.dto.UsuarioAtivoDto;
import io.github.cellrepair.dto.UsuarioDto;
import io.github.cellrepair.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService userService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>> findAll(
            @PageableDefault(size = 10, sort = "nomeUsuario")Pageable pageable
            ){
        var usuarios = userService.findAll(pageable);
        return ResponseEntity.ok().body(usuarios);
    }

    @PatchMapping("/{usuarioId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioDto> atualizarStatus(
            @PathVariable Long usuarioId,
            @RequestBody
            @Valid
            UsuarioAtivoDto usuarioAtivoDto){

        UsuarioDto usuarioAtualizado = userService.atualizarStatus(usuarioId, usuarioAtivoDto);
        return ResponseEntity.ok(usuarioAtualizado);

    }
}
