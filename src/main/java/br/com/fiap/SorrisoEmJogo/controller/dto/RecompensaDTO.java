package br.com.fiap.SorrisoEmJogo.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class RecompensaDTO {

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Pontos necessários são obrigatórios")
    @Positive(message = "Os pontos necessários devem ser maiores que zero")
    private Float pontosNecessarios;
}
