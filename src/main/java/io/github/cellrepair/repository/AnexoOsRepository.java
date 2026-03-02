package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.AnexoOs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnexoOsRepository extends JpaRepository<AnexoOs, Long> {

    boolean existsById(Long id);

    List<AnexoOs> findByOrdemServicoId(Long id);
}
