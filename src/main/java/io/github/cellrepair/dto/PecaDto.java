package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class PecaDto {

    public interface PecaView {
        public static interface PecaPost{}
        public static interface PecaPut{}
    }

    @JsonView(PecaView.PecaPut.class)
    private Long id;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    private String codigoBarras;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    private String numeroSerie;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    @NotNull(message = "A quantidade em estoque é obrigatória")
    private Integer quantidadeEstoque;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    private Integer estoqueMinimo;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    private Integer estoqueMaximo;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    @NotNull(message = "O preço de custo é obrigatório")
    private Double precoCusto;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    @NotNull(message = "O preço de venda é obrigatório")
    private Double precoVenda;

    @JsonView({PecaView.PecaPost.class, PecaView.PecaPut.class})
    private String fornecedor;
}
