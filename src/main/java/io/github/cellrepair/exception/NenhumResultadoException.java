package io.github.cellrepair.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
public class NenhumResultadoException extends ResponseStatusException implements ICustomException {

    private String message = "Nenhum resultado encontrado.";
    private List<String> messages;

    public NenhumResultadoException(){
        super(HttpStatus.NOT_FOUND, "Nenhum resultado encontrado.");
    }

    public NenhumResultadoException(String message){
        super(HttpStatus.NOT_FOUND, message);
        this.message = message;
    }

    public NenhumResultadoException(List<String> messages){
        super(HttpStatus.NOT_FOUND, messages.toString());
        this.messages = messages;
    }
}
