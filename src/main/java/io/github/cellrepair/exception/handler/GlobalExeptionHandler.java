package io.github.cellrepair.exception.handler;

import io.github.cellrepair.exception.ErroRespostaDto;
import io.github.cellrepair.exception.ICustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErroRespostaDto> handleResponseStatusException(ResponseStatusException ex){

        List<String> detalhesExcecao = null;


        if (ex instanceof ICustomException customException) {
            detalhesExcecao = customException.getMessages();
        }

        ErroRespostaDto erroRespostaDto = new ErroRespostaDto(
                LocalDateTime.now(),
                ex.getStatusCode().value(),
                ex.getStatusCode().toString(),
                ex.getReason(),
                null
        );

        return ResponseEntity.status(ex.getStatusCode()).body(erroRespostaDto);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDto> handlerValidationException(MethodArgumentNotValidException e){
        List<String> errosDeValidacao = e.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErroRespostaDto erro = new ErroRespostaDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro de Validação",
                "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.",
                errosDeValidacao
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

    }



}
