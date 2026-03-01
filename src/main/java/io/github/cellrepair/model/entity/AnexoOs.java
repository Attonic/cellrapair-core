package io.github.cellrepair.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "anexo_os")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnexoOs implements Serializable {

    @Id
    @Column(name = "id_anexo_os")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_os", nullable = false)
    @JsonBackReference
    private OrdemServico ordemServico;

    @Column(name = "nome_arquivo", nullable = false, length = 100)
    private String nomeArquivo;

    @Column(name = "tipo_arquivo", length = 50)
    private String tipoArquivo;

    @Column(name = "cam_arquivo", nullable = false, length = 500)
    private String camArquivo;

    @Column(name = "data_upload")
    @CreationTimestamp
    private Timestamp dataUpload;

    @Column(name = "observacao", length = 255)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioCriacao;
}
