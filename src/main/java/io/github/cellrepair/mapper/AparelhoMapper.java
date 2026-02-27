package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.AparelhoDto;
import io.github.cellrepair.model.entity.Aparelho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AparelhoMapper {

    Aparelho toEntity(AparelhoDto aparelhoDto);

    AparelhoDto toDto(Aparelho aparelho);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AparelhoDto aparelhoDto, @MappingTarget Aparelho aparelhoExistente);

}
