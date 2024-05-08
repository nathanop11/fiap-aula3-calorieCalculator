package br.com.fiap.fiapcap3calorieCalculator.dto;

public record AlimentoCadastroDTO (
        Long alimentoId,
        String nome,
        String porcao,
        Double quantidadeProteina,
        Double quantidadeCarboidrato,
        Double quantidadeGorduras
){
}
