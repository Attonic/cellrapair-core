package io.github.cellrepair.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tecnico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private Long id;

    @Column(name = "nome_tecnico", length = 150)
    private String nomeTecnico;

    @Column(name = "cpf_tecnico", length = 11, unique = true)
    private String cpfTecnico;

    @Column(name = "dt_nasc")
    private LocalDate dataNascimento;

    @Column(length = 80)
    private String especialidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal comissao;

    @Column
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrdemServico> ordemServicos = new ArrayList<>();

}