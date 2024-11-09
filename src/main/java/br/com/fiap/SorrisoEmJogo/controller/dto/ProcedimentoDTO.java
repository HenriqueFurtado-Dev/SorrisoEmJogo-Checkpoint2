package br.com.fiap.SorrisoEmJogo.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProcedimentoDTO {

    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;
}
