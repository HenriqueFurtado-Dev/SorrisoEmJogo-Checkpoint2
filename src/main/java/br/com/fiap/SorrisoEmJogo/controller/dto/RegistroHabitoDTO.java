package br.com.fiap.SorrisoEmJogo.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class RegistroHabitoDTO {

    @NotNull(message = "Data é obrigatória")
    private Date data;

    private String imagem;

    private String observacoes;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;

    @NotNull(message = "ID do hábito é obrigatório")
    private Long habitoId;
}
