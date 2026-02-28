package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    
    boolean existsByCpfTecnico(String cpfTecnico);

    boolean existsByCpfTecnicoAndIdNot(String cpfTecnico, Long id);
    
}
