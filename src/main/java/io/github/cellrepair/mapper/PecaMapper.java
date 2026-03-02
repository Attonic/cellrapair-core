package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.ClienteDto;
import io.github.cellrepair.dto.PecaDto;
import io.github.cellrepair.model.entity.Cliente;
import io.github.cellrepair.model.entity.Peca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PecaMapper {

    Peca toEntity(PecaDto pecaDto);

    PecaDto toDto(Peca peca);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PecaDto dto, @MappingTarget Peca pecaExistente);
}
