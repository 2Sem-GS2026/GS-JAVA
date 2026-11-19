package br.com.fiap.calcadalivre.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TIPO_OCORRENCIA")
@Getter
@Setter
public class TipoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_ocorrencia")
    @SequenceGenerator(name = "seq_tipo_ocorrencia", sequenceName = "seq_tipo_ocorrencia", allocationSize = 1)
    @Column(name = "ID_TIPO")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60, unique = true)
    private String nome;

    @Column(name = "DESCRICAO", length = 200)
    private String descricao;

    @Column(name = "GRAVIDADE_PADRAO", nullable = false)
    private Integer gravidadePadrao;
}