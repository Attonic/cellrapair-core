package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ClienteDto {

    public interface ClienteView {
        public static interface ClientePost{}
        public static interface ClientePut{}
    }

    @JsonView(ClienteView.ClientePut.class)
    private Long id;


    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    @NotBlank(groups = {ClienteView.ClientePost.class, ClienteView.ClientePut.class},
             message = "Nome do Cliente deve ser Informado.")
    private String nomeCompleto;

    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    @NotBlank(groups = {ClienteView.ClientePost.class, ClienteView.ClientePut.class},
              message = "CPF ou CNPJ deve ser informado.")
    private String cpfCnpj;

    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    private LocalDate dataNascimento;


    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    @NotBlank(groups = {ClienteView.ClientePost.class, ClienteView.ClientePut.class},
            message = "Informe o telefone do Cliente.")
    private String telefone;

    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    @NotBlank(groups = {ClienteView.ClientePost.class, ClienteView.ClientePut.class},
            message = "O Email do clinte deve ser informado.")
    private String email;

    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    private String endereco;

    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    private String cidade;

    @JsonView({ClienteView.ClientePost.class, ClienteView.ClientePut.class})
    private String uf;

}
