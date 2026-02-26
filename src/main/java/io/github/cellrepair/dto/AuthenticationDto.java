package io.github.cellrepair.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDto(
        @NotNull
        String nomeUsuario,
        @NotNull
        String senha) {
}
