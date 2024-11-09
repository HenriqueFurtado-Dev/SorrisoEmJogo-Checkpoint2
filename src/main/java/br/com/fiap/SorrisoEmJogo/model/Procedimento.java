package br.com.fiap.SorrisoEmJogo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "procedimento")
@Data
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedimento_id")
    private Long procedimentoId;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @ManyToMany(mappedBy = "procedimentos")
    private List<Unidade> unidades;
}
