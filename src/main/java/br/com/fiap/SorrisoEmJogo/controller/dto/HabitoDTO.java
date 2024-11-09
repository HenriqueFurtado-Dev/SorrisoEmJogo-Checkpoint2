package br.com.fiap.SorrisoEmJogo.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HabitoDTO {

    @NotNull(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Tipo é obrigatório")
    private String tipo;

    @NotNull(message = "Frequência ideal é obrigatória")
    private Float frequenciaIdeal;
}
