package br.com.fiap.calcadalivre.repository;

import br.com.fiap.calcadalivre.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
}