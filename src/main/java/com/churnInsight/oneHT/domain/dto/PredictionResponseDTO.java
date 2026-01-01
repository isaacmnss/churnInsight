package com.churnInsight.oneHT.domain.dto;

import java.time.LocalDateTime;

public record PredictionResponseDTO(
        Double ProbabilidadeChurn,
        boolean vaiCancelar,
        LocalDateTime timeStamp
) {

}
