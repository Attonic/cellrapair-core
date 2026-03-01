package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.AnexoOsDto;
import io.github.cellrepair.model.entity.AnexoOs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AnexoOsMapper {

    @Mapping(target = "ordemServico.id", source = "ordemServicoId")
    @Mapping(target = "usuarioCriacao.id", source = "usuarioCriacaoId")
    AnexoOs toEntity(AnexoOsDto anexoOsDto);

    @Mapping(target = "ordemServicoId", source = "ordemServico.id")
    @Mapping(target = "usuarioCriacaoId", source = "usuarioCriacao.id")
    AnexoOsDto toDto(AnexoOs anexoOs);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AnexoOsDto anexoOsDto, @MappingTarget AnexoOs anexoOs);
}
