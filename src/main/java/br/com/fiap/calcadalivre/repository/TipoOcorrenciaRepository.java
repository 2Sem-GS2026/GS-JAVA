package br.com.fiap.calcadalivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.calcadalivre.model.TipoOcorrencia;

public interface TipoOcorrenciaRepository extends JpaRepository<TipoOcorrencia, Long> {
}