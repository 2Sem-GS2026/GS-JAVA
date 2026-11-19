
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
@Table(name = "LOGRADOURO")
@Getter @Setter
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_logradouro")
    @SequenceGenerator(name = "seq_logradouro", sequenceName = "seq_logradouro", allocationSize = 1)
    @Column(name = "ID_LOGRADOURO")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "BAIRRO", nullable = false, length = 50)
    private String bairro;

    @Column(name = "CIDADE", nullable = false, length = 50)
    private String cidade;
}