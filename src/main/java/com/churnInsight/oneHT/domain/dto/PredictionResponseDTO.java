package com.churnInsight.oneHT.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record PredictionResponseDTO(

        @JsonProperty("prediction")
        Integer prediction,

        @JsonProperty("churn_probability")
        Double churnProbability,

        @JsonProperty("risk_message")
        String riskMessage,

        @JsonProperty("timeStamp")
        LocalDateTime timeStamp
) {

}
