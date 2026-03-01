package io.github.cellrepair.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.cellrepair.exception.NenhumResultadoException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_os")
    private Long id;

    @Column(name = "imei", length = 20)
    private String imei;

    @Column(name = "cor", length = 30)
    private String cor;

    @Column(name = "acessorios", length = 100)
    private String acessorios;

    @Column(name = "senha", length = 50)
    private String senha;

    @Column(name = "dt_entrada", updatable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataEntrada;

    @Column(name = "dt_saida")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataSaida;

    @Column(name = "defeito_relatado", length = 600)
    private String defeitoRelatado;

    @Column(name = "laudo_tecnico", length = 600)
    private String laudoTecnico;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aparelhos", nullable = false)
    private Aparelho aparelho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tecnico", nullable = false)
    private Tecnico tecnico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_abertura")
    private Usuario usuario;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemOs> itensOs;

    public void adicionarItem(ItemOs item) {
        this.itensOs.add(item);
        item.setOrdemServico(this);
    }

}
