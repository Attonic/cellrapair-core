package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.model.entity.OrdemServico;
import io.github.cellrepair.model.entity.Peca;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ItemOsDto {

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    private Long id;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo ordemServicoId é obrigatório.")
    private Long ordemServicoId;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo pecaId é obrigatório.")
    private Long pecaId;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo quantidade é obrigatório.")
    private Integer quantidade;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo valorUnitario é obrigatório.")
    private BigDecimal valorUnitario;

}
