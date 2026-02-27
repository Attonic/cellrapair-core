package io.github.cellrepair.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "aparelho")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aparelho implements Serializable {

    @Id
    @Column(name = "id_aparelhos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String marca;

    @Column(length = 34)
    private String modelo;

    @Column(length = 45)
    private String versao;

}
