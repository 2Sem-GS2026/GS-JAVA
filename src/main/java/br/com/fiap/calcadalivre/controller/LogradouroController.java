package br.com.fiap.calcadalivre.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calcadalivre.model.Logradouro;
import br.com.fiap.calcadalivre.repository.LogradouroRepository;

@RestController
@RequestMapping("/logradouros")
public class LogradouroController {

    private final LogradouroRepository repository;

    public LogradouroController(LogradouroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Logradouro> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logradouro> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}