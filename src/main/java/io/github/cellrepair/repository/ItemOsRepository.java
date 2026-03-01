package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.ItemOs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOsRepository extends JpaRepository<ItemOs, Long> {

    boolean existsById(Long id);

    List<ItemOs> findByOrdemServicoId(Long id);
}
