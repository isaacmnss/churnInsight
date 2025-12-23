package com.churnInsight.oneHT.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestPredictionDTO(
        @NotNull
        Integer creditScore,

        @NotBlank
        String geography,

        @NotBlank
        String genero,

        @NotNull
        @Min(0)
        Integer age,

        @NotNull
        Integer tenure,

        @NotNull
        Double balance,

        @NotNull Integer numOfProducts,

        @NotNull Integer hasCrCard,

        @NotNull
        Integer isActiveMember,

        @NotNull
        Double satisfactionScore,

        @NotNull
        Double estimatedSalary,

        @NotNull
        Integer pointEarned,

        @NotBlank
        String cardType
) {
}
