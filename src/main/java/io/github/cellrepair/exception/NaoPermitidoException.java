package io.github.cellrepair.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
public class NaoPermitidoException extends ResponseStatusException implements ICustomException {

    private String message;
    private List<String> messages;

    public NaoPermitidoException(){
        super(HttpStatus.FORBIDDEN, "Acesso não permitido.");
        this.message = "Acesso não permitido.";
    }

}
