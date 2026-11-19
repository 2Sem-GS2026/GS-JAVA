package br.com.fiap.calcadalivre.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calcadalivre.model.ConfirmacaoOcorrencia;
import br.com.fiap.calcadalivre.repository.ConfirmacaoOcorrenciaRepository;

@RestController
@RequestMapping("/confirmacoes")
public class ConfirmacaoOcorrenciaController {

    private final ConfirmacaoOcorrenciaRepository repository;

    public ConfirmacaoOcorrenciaController(ConfirmacaoOcorrenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ConfirmacaoOcorrencia> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfirmacaoOcorrencia> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConfirmacaoOcorrencia> criar(@RequestBody ConfirmacaoOcorrencia confirmacao) {
        confirmacao.setId(null);
        if (confirmacao.getDataConfirmacao() == null) {
            confirmacao.setDataConfirmacao(LocalDate.now());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(confirmacao));
    }
}