package io.github.cellrepair.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErroRespostaDto {
    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String mensagem;
    private List<String> detalhes;
}
