package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    boolean existsById(Long id);

}
