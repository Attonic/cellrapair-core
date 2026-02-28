package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.OrdemServicoDto;
import io.github.cellrepair.model.entity.OrdemServico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrdemServicoMapper {

    OrdemServico toEntity(OrdemServicoDto ordemServicoDto);

    OrdemServicoDto toDto(OrdemServico ordemServico);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(OrdemServicoDto ordemServicoDto, @MappingTarget OrdemServico ordemServico);

}
