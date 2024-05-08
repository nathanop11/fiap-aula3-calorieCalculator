package br.com.fiap.fiapcap3calorieCalculator.dto;

public record UsuarioCadastroDTO(
        Long usuarioId,
        String nome,
        String email,
        String senha
) {
}
