package com.churnInsight.oneHT.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record RequestPredictionDTO(

        @JsonProperty("CreditScore")
        @NotNull
        @Positive
        Integer creditScore,

        @JsonProperty("Geography")
        @NotBlank
        String geography,

        @JsonProperty("Gender")
        @NotBlank
        String gender,

        @JsonProperty("Age")
        @NotNull
        @Min(18)
        Integer age,

        @JsonProperty("Tenure")
        @NotNull
        Integer tenure,

        @JsonProperty("Balance")
        @NotNull
        Double balance,

        @JsonProperty("NumOfProducts")
        @NotNull
        Integer numOfProducts,

        @JsonProperty("HasCrCard")
        @NotNull
        Boolean hasCrCard,

        @JsonProperty("IsActiveMember")
        @NotNull
        Boolean isActiveMember,

        @JsonProperty("EstimatedSalary")
        @NotNull
        Double estimatedSalary,

        @JsonProperty("Satisfaction_Score")
        @NotNull
        Integer satisfactionScore,

        @JsonProperty("Point_Earned")
        @NotNull
        Integer pointEarned,

        @JsonProperty("CardType")
        @NotBlank
        String cardType
) {
}
