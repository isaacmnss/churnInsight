package com.churnInsight.oneHT.dto;

import java.time.LocalDateTime;

public record PredictionResponseDTO(
        Double ProbabilidadeChurn,
        boolean vaiCancelar,
        LocalDateTime timeStamp
) {

}
