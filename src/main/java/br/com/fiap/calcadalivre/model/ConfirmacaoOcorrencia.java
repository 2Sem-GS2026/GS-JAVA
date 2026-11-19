package br.com.fiap.calcadalivre.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CONFIRMACAO_OCORRENCIA",
        uniqueConstraints = @UniqueConstraint(columnNames = {"USUARIO_ID_USUARIO", "OCORRENCIA_ID_OCORRENCIA"}))
@Getter
@Setter
public class ConfirmacaoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_confirmacao")
    @SequenceGenerator(name = "seq_confirmacao", sequenceName = "seq_confirmacao", allocationSize = 1)
    @Column(name = "ID_CONFIRMACAO")
    private Long id;

    @Column(name = "DATA_CONFIRMACAO", nullable = false)
    private LocalDate dataConfirmacao;

    @Column(name = "AINDA_EXISTE", nullable = false, length = 1)
    private String aindaExiste;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID_USUARIO", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "OCORRENCIA_ID_OCORRENCIA", nullable = false)
    private Ocorrencia ocorrencia;
}