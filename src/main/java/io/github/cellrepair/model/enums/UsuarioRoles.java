package io.github.cellrepair.model.enums;

public enum UserRoles {
    ADMIN("admin"),
    TECNINCO("tecnico");

    private String role;

    UserRoles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
