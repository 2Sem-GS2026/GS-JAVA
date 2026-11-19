package br.com.fiap.calcadalivre.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OCORRENCIA")
@Getter
@Setter
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ocorrencia")
    @SequenceGenerator(name = "seq_ocorrencia", sequenceName = "seq_ocorrencia", allocationSize = 1)
    @Column(name = "ID_OCORRENCIA")
    private Long id;

    @Column(name = "DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "DATA_REGISTRO", nullable = false)
    private LocalDate dataRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 15)
    private StatusOcorrencia status;

    @Column(name = "DATA_RESOLUCAO")
    private LocalDate dataResolucao;

    @ManyToOne
    @JoinColumn(name = "ID_TRECHO", nullable = false)
    private TrechoCalcada trecho;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO", nullable = false)
    private TipoOcorrencia tipo;
}