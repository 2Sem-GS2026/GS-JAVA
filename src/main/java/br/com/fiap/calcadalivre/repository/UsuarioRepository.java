package br.com.fiap.calcadalivre.repository;

import br.com.fiap.calcadalivre.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
