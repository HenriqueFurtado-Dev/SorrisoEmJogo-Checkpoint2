package br.com.fiap.SorrisoEmJogo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "unidade")
@Data
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unidade_id")
    private Long unidadeId;

    @Column(nullable = false)
    private String nome;

    private String estado;
    private String cidade;
    private String endereco;

    @ManyToMany
    @JoinTable(
            name = "procedimentos_da_unidade",
            joinColumns = @JoinColumn(name = "unidade_id"),
            inverseJoinColumns = @JoinColumn(name = "procedimento_id")
    )
    private List<Procedimento> procedimentos;
}
