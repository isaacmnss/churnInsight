package com.churnInsight.oneHT.domain.dto;

import com.churnInsight.oneHT.domain.Enum.CardType;
import com.churnInsight.oneHT.domain.Enum.Gender;
import com.churnInsight.oneHT.domain.Enum.Geography;
import jakarta.validation.constraints.*;

public record RequestPredictionDTO(
        @NotNull
        @Positive
        Integer creditScore,

        @NotNull
        Geography geography,

        @NotNull
        Gender gender,

        @NotNull
        @Min(18)
        Integer age,

        @NotNull
        @PositiveOrZero
        Integer tenure,

        @NotNull
        @PositiveOrZero
        Double balance,

        @NotNull Integer numOfProducts,

        boolean hasCrCard,

        boolean isActiveMember,

        @NotNull
        @Min(1) @Max(5)
        Double satisfactionScore,

        @NotNull
        @PositiveOrZero
        Double estimatedSalary,

        @NotNull
        @PositiveOrZero
        Integer pointEarned,

        @NotNull
        CardType cardType
) {
}
