package br.com.fiap.fiapcap3calorieCalculator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(
        @NotBlank(message = "Obrigatorio!")
        @Email(message = "Email")
        String email,

        @NotBlank
        @Size (min = 6, max = 20)
        String senha
) {


}
