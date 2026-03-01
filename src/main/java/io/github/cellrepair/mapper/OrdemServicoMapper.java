package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.OrdemServicoDto;
import io.github.cellrepair.model.entity.OrdemServico;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ItemOsMapper.class})
public interface OrdemServicoMapper {

    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "aparelho.id", source = "aparelhoId")
    @Mapping(target = "tecnico.id", source = "tecnicoId")
    @Mapping(target = "usuario.id", source = "usuarioId")
    OrdemServico toEntity(OrdemServicoDto ordemServicoDto);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "aparelhoId", source = "aparelho.id")
    @Mapping(target = "tecnicoId", source = "tecnico.id")
    @Mapping(target = "usuarioId", source = "usuario.id")
    OrdemServicoDto toDto(OrdemServico ordemServico);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(OrdemServicoDto ordemServicoDto, @MappingTarget OrdemServico ordemServico);

}
