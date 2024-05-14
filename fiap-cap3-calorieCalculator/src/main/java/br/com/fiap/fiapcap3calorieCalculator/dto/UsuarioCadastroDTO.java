package br.com.fiap.fiapcap3calorieCalculator.dto;

import br.com.fiap.fiapcap3calorieCalculator.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDTO(
        Long usuarioId,
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 6, max = 10)
        String senha,
        UsuarioRole role
) {
}
