package org.gen.personalponderings.repositories;

import org.gen.personalponderings.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);

    public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
