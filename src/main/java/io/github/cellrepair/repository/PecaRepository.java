package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
    boolean existsById(Long id);

    boolean existsByDescricao(String descricao);

    boolean existsByDescricaoAndIdNot(String descricao, Long id);


}
