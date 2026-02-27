package io.github.cellrepair.mapper;


import io.github.cellrepair.dto.ClienteDto;
import io.github.cellrepair.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDto clienteDto);

    ClienteDto toDto(Cliente cliente);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ClienteDto dto, @MappingTarget Cliente clienteExistente);

}
