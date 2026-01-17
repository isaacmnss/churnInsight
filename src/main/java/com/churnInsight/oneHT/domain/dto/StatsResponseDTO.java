package com.churnInsight.oneHT.domain.dto;

public record StatsResponseDTO(
        long numeroDePrevisoes,
        Double churnMedio
) {
}
