package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
    boolean existsById(Long id);
}
