package br.com.fiap.SorrisoEmJogo.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;

    @NotNull(message = "Pontos de recompensa são obrigatórios")
    @Min(value = 0, message = "Os pontos de recompensa não podem ser negativos")
    @Max(value = 1000, message = "Os pontos de recompensa não podem ser superiores a 1000")
    private Float pontosRecompensa;
}
