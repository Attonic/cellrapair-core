package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TecnicoDto {

    public interface TecnicoView{
        public static interface TecnicoPut{}
        public static interface TecnicoPost{}
    }

    @JsonView({TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class})
    private String nomeTecnico;

    @JsonView({TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class})
    @NotBlank(groups = {TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class},
              message = "O CPF do Técnico deve ser informado.")
    private String cpfTecnico;

    @JsonView({TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class})
    private LocalDate dataNascimento;

    @JsonView({TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class})
    private String especialidade;

    @JsonView({TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class})
    private BigDecimal comissao;

    @JsonView({TecnicoView.TecnicoPost.class, TecnicoView.TecnicoPut.class})
    private Boolean status;

    @JsonView({TecnicoView.TecnicoPost.class})
    @NotNull(message = "Os dados de usuário devem ser informados.")
    private UsuarioDto usuario;

}
