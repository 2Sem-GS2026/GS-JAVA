package br.com.fiap.calcadalivre.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calcadalivre.model.TrechoCalcada;
import br.com.fiap.calcadalivre.repository.TrechoCalcadaRepository;

@RestController
@RequestMapping("/trechos")
public class TrechoCalcadaController {

    private final TrechoCalcadaRepository repository;

    public TrechoCalcadaController(TrechoCalcadaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TrechoCalcada> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrechoCalcada> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrechoCalcada> criar(@RequestBody TrechoCalcada trecho) {
        trecho.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(trecho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrechoCalcada> atualizar(@PathVariable Long id, @RequestBody TrechoCalcada trecho) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        trecho.setId(id);
        return ResponseEntity.ok(repository.save(trecho));
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