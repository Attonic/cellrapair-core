package io.github.cellrepair.dto;

import io.github.cellrepair.model.enums.UsuarioRoles;

public record RegisterDto (
        String nomeUsuario,
        String senha,
        UsuarioRoles role
){
}
