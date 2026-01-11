package com.churnInsight.oneHT.domain.mapper;

import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import com.churnInsight.oneHT.domain.entity.ChurnPrediction;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ChurnPrediction  requestPredictionDTOToChurnPrediction(RequestPredictionDTO requestPredictionDTO);

    default ChurnPrediction toCompleteChurnPrediction(RequestPredictionDTO request, PredictionResponseDTO predictionResponseDTO) {
        ChurnPrediction churnPrediction = requestPredictionDTOToChurnPrediction(request);

        churnPrediction.setPrediction(predictionResponseDTO.prediction() == 1);
        churnPrediction.setChurnProbability(predictionResponseDTO.churnProbability());
        churnPrediction.setRiskMessage(predictionResponseDTO.riskMessage());
        churnPrediction.setCreatedAt(LocalDateTime.now());

        return churnPrediction;
    }

}

