package br.com.fiap.calcadalivre.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calcadalivre.model.Ocorrencia;
import br.com.fiap.calcadalivre.model.StatusOcorrencia;
import br.com.fiap.calcadalivre.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaRepository repository;

    public OcorrenciaController(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    // GET /ocorrencias            -> todas
    // GET /ocorrencias?status=ABERTA -> filtra por status
    @GetMapping
    public List<Ocorrencia> listar(@RequestParam(required = false) StatusOcorrencia status) {
        if (status != null) {
            return repository.findByStatus(status);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ocorrencias de um trecho (usado pela parte de rotas e de dados)
    @GetMapping("/trecho/{idTrecho}")
    public List<Ocorrencia> listarPorTrecho(@PathVariable Long idTrecho) {
        return repository.findByTrechoId(idTrecho);
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> criar(@RequestBody Ocorrencia ocorrencia) {
        ocorrencia.setId(null);
        if (ocorrencia.getDataRegistro() == null) {
            ocorrencia.setDataRegistro(LocalDate.now());
        }
        if (ocorrencia.getStatus() == null) {
            ocorrencia.setStatus(StatusOcorrencia.ABERTA);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ocorrencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ocorrencia.setId(id);
        return ResponseEntity.ok(repository.save(ocorrencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}