package io.github.cellrepair.repository;

import io.github.cellrepair.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByNomeUsuario(String nomeUsuario);

    boolean existsByNomeUsuario(String nomeUsuario);
}
