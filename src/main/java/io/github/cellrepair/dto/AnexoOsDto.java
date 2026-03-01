package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.model.entity.OrdemServico;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class AnexoOsDto {

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    private Long id;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo ordemServicoId é obrigatório.")
    private Long ordemServicoId;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo usuarioCriacaoId é obrigatório.")
    private Long usuarioCriacaoId;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo nomeArquivo é obrigatório.")
    private String nomeArquivo;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    private String tipoArquivo;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    @NotNull(groups = {OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class},
            message = "O campo camArquivo é obrigatório.")
    private String caminhoArquivo;

    @JsonView({OrdemServicoDto.OrdemServicoView.OrdemServicoPost.class, OrdemServicoDto.OrdemServicoView.OrdemServicoPut.class})
    private String observacao;
}
