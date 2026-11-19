package br.com.fiap.calcadalivre.repository;

import br.com.fiap.calcadalivre.model.Ocorrencia;
import br.com.fiap.calcadalivre.model.StatusOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByStatus(StatusOcorrencia status);

    List<Ocorrencia> findByTrechoId(Long idTrecho);
}
