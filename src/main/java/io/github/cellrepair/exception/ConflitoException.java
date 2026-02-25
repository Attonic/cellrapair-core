package io.github.cellrepair.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
public class ConflitoException extends ResponseStatusException implements ICustomException {

    private String message;
    private List<String> messages;

    public ConflitoException(String message){
        super(HttpStatus.CONFLICT, message);
        this.message = message;
    }

    public ConflitoException(List<String> messages){
        super(HttpStatus.CONFLICT, messages.toString());
        this.messages = messages;
    }

}
