package io.github.cellrepair.mapper;

import io.github.cellrepair.dto.UsuarioDto;
import io.github.cellrepair.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    Usuario toEntity(UsuarioDto usuarioDto);

    @Mapping(target = "senha", ignore = true)
    UsuarioDto toDto(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(UsuarioDto usuarioDto, @MappingTarget Usuario usuario);

}
