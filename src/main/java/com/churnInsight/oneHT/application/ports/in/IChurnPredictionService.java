package com.churnInsight.oneHT.application.ports.in;

import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;

public interface IChurnPredictionService {

    PredictionResponseDTO predict(RequestPredictionDTO request);

}
