package br.com.fiap.fiapcap3calorieCalculator.dto;

import br.com.fiap.fiapcap3calorieCalculator.model.Alimento;

public record AlimentoExibicaoDTO(Long alimentoId,
                                  String nome,
                                  String porcao,
                                  Double quantidadeProteina,
                                  Double quantidadeCarboidrato,
                                  Double quantidadeGorduras,
                                  Double totalCalorias
) {

    public AlimentoExibicaoDTO(Alimento alimento){
        this(
                alimento.getAlimentoId(),
                alimento.getNome(),
                alimento.getPorcao(),
                alimento.getQuantidadeProteina(),
                alimento.getQuantidadeCarboidrato(),
                alimento.getQuantidadeGorduras(),
                alimento.getTotalCalorias()
        );
    }
}
