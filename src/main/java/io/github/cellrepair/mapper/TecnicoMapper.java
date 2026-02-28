package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.TecnicoDto;
import io.github.cellrepair.model.entity.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TecnicoMapper{

    Tecnico toEntity(TecnicoDto tecnicoDto);

    TecnicoDto toDto(Tecnico tecnico);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(TecnicoDto tecnicoDto, @MappingTarget Tecnico tecnicoExistente);
}
