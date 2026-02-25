package io.github.cellrepair.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
public class NaoAutorizadoException extends ResponseStatusException implements ICustomException {
    private String message;
    private List<String> messages;

    public NaoAutorizadoException() {
        super(HttpStatus.UNAUTHORIZED, "Usuário e/ou senha inválidos.");
        this.message = "Usuário e/ou senha inválidos.";
    }
}
