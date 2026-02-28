package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.model.enums.UsuarioRoles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioDto(

        @NotBlank(message = "Nome de Usuário deve ser informado")
        @JsonView({TecnicoDto.TecnicoView.TecnicoPost.class, TecnicoDto.TecnicoView.TecnicoPut.class})
        String nomeUsuario,

        @NotBlank(message = "A Senha deve ser informado")
        @JsonView({TecnicoDto.TecnicoView.TecnicoPost.class, TecnicoDto.TecnicoView.TecnicoPut.class})
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String senha,

        @JsonView({TecnicoDto.TecnicoView.TecnicoPost.class, TecnicoDto.TecnicoView.TecnicoPut.class})
        @NotNull(message = "A Role de Usuário deve ser informado")
        UsuarioRoles role
){
}
