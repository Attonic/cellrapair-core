package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByEmail(String email);

    boolean existsByCpfCnpjAndIdNot(String cpfCnpj, Long id);

    boolean existsByEmailAndIdNot(String email, Long id);

}
