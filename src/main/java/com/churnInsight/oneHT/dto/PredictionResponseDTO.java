package com.churnInsight.oneHT.dto;

public record PredictionResponseDTO(
        Double ProbabilidadeChurn,
        boolean vaiCancelar
) {

}
