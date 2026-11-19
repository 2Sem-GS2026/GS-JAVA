package br.com.fiap.calcadalivre.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calcadalivre.model.TipoOcorrencia;
import br.com.fiap.calcadalivre.repository.TipoOcorrenciaRepository;

@RestController
@RequestMapping("/tipos-ocorrencia")
public class TipoOcorrenciaController {

    private final TipoOcorrenciaRepository repository;

    public TipoOcorrenciaController(TipoOcorrenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TipoOcorrencia> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOcorrencia> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}