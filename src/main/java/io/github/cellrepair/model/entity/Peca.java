package io.github.cellrepair.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "peca")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pecas")
    private Long id;

    @Column(name = "cod_barras", length = 45)
    private String codigoBarras;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "num_serie", length = 50)
    private String numeroSerie;

    @Column(name = "qtd_estoque")
    private Integer quantidadeEstoque;

    @Column(name = "est_minimo")
    private Integer estoqueMinimo;

    @Column(name = "est_maximo")
    private Integer estoqueMaximo;

    @Column(name = "preco_custo")
    private Double precoCusto;

    @Column(name = "preco_venda")
    private Double precoVenda;

    @Column(name = "fornecedor", length = 100)
    private String fornecedor;
}
