package io.github.cellrepair.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_os")
public class ItemOs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_os")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_os", nullable = false)
    @JsonBackReference
    private OrdemServico ordemServico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_peca", nullable = false)
    private Peca peca;

    @Column(name = "qtd", nullable = false)
    private Integer quantidade;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;
}
