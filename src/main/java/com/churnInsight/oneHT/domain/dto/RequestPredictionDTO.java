package com.churnInsight.oneHT.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record RequestPredictionDTO(

        @Schema(example = "200")
        @JsonProperty("CreditScore")
        @NotNull
        @Positive
        Integer creditScore,

        @Schema(example = "FRANCE")
        @JsonProperty("Geography")
        @NotBlank
        String geography,

        @Schema(example = "FEMALE")
        @JsonProperty("Gender")
        @NotBlank
        String gender,

        @Schema(example = "21")
        @JsonProperty("Age")
        @NotNull
        @Min(18)
        Integer age,

        @Schema(example = "3")
        @JsonProperty("Tenure")
        @NotNull
        Integer tenure,

        @Schema(example = "2500.00")
        @JsonProperty("Balance")
        @NotNull
        Double balance,

        @Schema(example = "3")
        @JsonProperty("NumOfProducts")
        @NotNull
        Integer numOfProducts,

        @Schema(example = "1")
        @JsonProperty("HasCrCard")
        @NotNull
        Boolean hasCrCard,

        @Schema(example = "0")
        @JsonProperty("IsActiveMember")
        @NotNull
        Boolean isActiveMember,

        @Schema(example = "2500.00")
        @JsonProperty("EstimatedSalary")
        @NotNull
        Double estimatedSalary,

        @Schema(example = "3")
        @JsonProperty("Satisfaction_Score")
        @NotNull
        Integer satisfactionScore,

        @Schema(example = "200")
        @JsonProperty("Point_Earned")
        @NotNull
        Integer pointEarned,

        @Schema(example = "DIAMOND")
        @JsonProperty("CardType")
        @NotBlank
        String cardType
) {
}
