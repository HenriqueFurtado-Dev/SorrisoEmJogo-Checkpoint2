package br.com.fiap.SorrisoEmJogo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UnidadeDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Estado é obrigatório")
    private String estado;

    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;
}
