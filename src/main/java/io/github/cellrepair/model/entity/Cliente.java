package io.github.cellrepair.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(length = 150)
    private String nomeCompleto;

    @Size(min = 11, max = 14)
    @Column(length = 14, nullable = false, unique = true)
    private String cpfCnpj;

    @Past
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 13)
    private String telefone;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String endereco;

    @Column(length = 100)
    private String cidade;

    @Size(min = 2, max = 2)
    @Column(length = 2)
    private String uf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<OrdemServico> ordemServicos = new ArrayList<>();


}
