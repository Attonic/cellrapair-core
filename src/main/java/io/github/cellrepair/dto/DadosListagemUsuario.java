package io.github.cellrepair.dto;

import io.github.cellrepair.model.entity.Usuario;

public record DadosListagemUsuario(
        String nome
) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getNomeUsuario());
    }
}
