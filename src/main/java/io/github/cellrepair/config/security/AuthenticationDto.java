package io.github.cellrepair.config.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthenticationDto(
        @NotNull
        String nomeUsuario,
        @NotNull
        String senha) {
}
