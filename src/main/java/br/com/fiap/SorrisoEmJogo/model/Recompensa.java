package br.com.fiap.SorrisoEmJogo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recompensa")
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recompensaId;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "pontos_necessarios", nullable = false)
    private Float pontosNecessarios;
}
