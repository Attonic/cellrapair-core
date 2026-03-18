package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UsuarioAtivoDto(

        @NotNull(message = "Deve ser informado se está ativo ou não.")
        @JsonView({TecnicoDto.TecnicoView.TecnicoPost.class, TecnicoDto.TecnicoView.TecnicoPut.class})
        Boolean ativo
) {
}
