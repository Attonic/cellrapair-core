package io.github.cellrepair.model.enums;

public enum UsuarioRoles {
    ADMIN("admin"),
    TECNINCO("tecnico");

    private String role;

    UsuarioRoles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
