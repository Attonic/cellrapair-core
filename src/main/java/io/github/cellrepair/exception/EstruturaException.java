package io.github.cellrepair.exception;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
public class EstruturaException extends ResponseStatusException implements ICustomException {

    private String message;
    private List<String> messages;

    public EstruturaException(String message){
        super(HttpStatus.EXPECTATION_FAILED, message);
        this.message = message;
    }

    public EstruturaException(List<String> messages){
        super(HttpStatus.EXPECTATION_FAILED, messages.toString());
        this.messages = messages;
    }

}
