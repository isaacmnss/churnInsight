package com.churnInsight.oneHT.application.service;

import com.churnInsight.oneHT.application.ports.in.IChurnPredictionService;
import com.churnInsight.oneHT.application.ports.out.ToolsDSClient;
import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import com.churnInsight.oneHT.domain.mapper.ClassMapper;
import com.churnInsight.oneHT.framework.adapters.out.ChurnPredictionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChurnPredictionServiceIMPL implements IChurnPredictionService {

    private final ChurnPredictionRepository repository;
    private final ClassMapper mapper;
    private final ToolsDSClient toolsDSClient;

    public PredictionResponseDTO predict(RequestPredictionDTO request) {
        try {
            var churnPrediction = mapper.requestPredictionDTOToChurnPrediction(request);
            var predictionResponseDTO = toolsDSClient.predictClient(request);
            var churnPredictionComplete = mapper.toCompleteChurnPrediction(request, predictionResponseDTO);

            repository.save(churnPredictionComplete);

            return new PredictionResponseDTO(predictionResponseDTO.prediction(), predictionResponseDTO.churnProbability(),
                    predictionResponseDTO.riskMessage(), churnPredictionComplete.getCreatedAt());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer predição: " + e.getMessage(), e);
        }

    }

}
