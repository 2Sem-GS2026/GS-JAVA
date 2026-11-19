package br.com.fiap.calcadalivre.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "TRECHO_CALCADA")
@Getter
@Setter
public class TrechoCalcada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_trecho_calcada")
    @SequenceGenerator(name = "seq_trecho_calcada", sequenceName = "seq_trecho_calcada", allocationSize = 1)
    @Column(name = "ID_TRECHO")
    private Long id;

    @Column(name = "LADO", nullable = false, length = 10)
    private String lado;

    @Column(name = "EXTENSAO_METROS", nullable = false, precision = 6, scale = 1)
    private BigDecimal extensaoMetros;

    @Column(name = "LARGURA_METROS", precision = 4, scale = 2)
    private BigDecimal larguraMetros;

    @Column(name = "POSSUI_RAMPA", nullable = false, length = 1)
    private String possuiRampa;

    @ManyToOne
    @JoinColumn(name = "ID_LOGRADOURO", nullable = false)
    private Logradouro logradouro;
}