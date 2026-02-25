package io.github.cellrepair.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
public class ValidacaoException extends ResponseStatusException implements ICustomException {

    private String message;
    private List<String> messages;

    public ValidacaoException(String message){
        super(HttpStatus.BAD_REQUEST, message);
        this.message = message;
    }

    public ValidacaoException(List<String> messages){
        super(HttpStatus.BAD_REQUEST, messages.toString());
        this.messages = messages;
    }

}
