package io.github.cellrepair.exception;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ICustomException {

    String getMessage();
    HttpStatusCode getStatusCode();
    List<String> getMessages();
    String getReason();

}
