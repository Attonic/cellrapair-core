package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.model.entity.ItemOs;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class OrdemServicoDto {

    public interface OrdemServicoView {
        public static interface OrdemServicoPost {
        }

        public static interface OrdemServicoPut {
        }

    }

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private Long id;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String imei;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String cor;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String acessorios;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String senha;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String defeitoRelatado;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String laudoTecnico;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private String status;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private BigDecimal valorTotal;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoView.OrdemServicoPost.class},
            message = "Cliente da O.S deve ser informado.")
    private Long clienteId;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoView.OrdemServicoPost.class},
            message = "Aparelho da O.S deve ser informado.")
    private Long aparelhoId;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoView.OrdemServicoPost.class},
            message = "Técnico da O.S deve ser informado.")
    private Long tecnicoId;

    private Long usuarioId;

    @JsonView({OrdemServicoView.OrdemServicoPost.class, OrdemServicoView.OrdemServicoPut.class})
    private List<ItemOsDto> itensOs;

}
