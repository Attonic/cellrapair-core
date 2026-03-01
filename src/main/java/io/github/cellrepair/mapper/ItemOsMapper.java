package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.ItemOsDto;
import io.github.cellrepair.model.entity.ItemOs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ItemOsMapper {

    @Mapping(target = "peca.id", source = "pecaId")
    @Mapping(target = "ordemServico.id", source = "ordemServicoId")
    ItemOs toEntity(ItemOsDto itemOsDto);

    @Mapping(target = "pecaId", source = "peca.id")
    @Mapping(target = "ordemServicoId", source = "ordemServico.id")
    ItemOsDto toDto(ItemOs item);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ItemOsDto itemOsDto, @MappingTarget ItemOs itemOs);
}
