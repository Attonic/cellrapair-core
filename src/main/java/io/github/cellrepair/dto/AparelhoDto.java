package io.github.cellrepair.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.ToString;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AparelhoDto {

    public interface AparelhoView{
        public static interface AparelhoPut{}
        public static interface AparelhoPost{}
    }

    @JsonView(AparelhoView.AparelhoPut.class)
    private Long id;

    @JsonView({AparelhoView.AparelhoPost.class, AparelhoView.AparelhoPut.class})
    private String marca;

    @JsonView({AparelhoView.AparelhoPost.class, AparelhoView.AparelhoPut.class})
    private String modelo;

    @JsonView({AparelhoView.AparelhoPost.class, AparelhoView.AparelhoPut.class})
    private String versao;


}
