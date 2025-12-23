package com.churnInsight.oneHT.service;

import com.churnInsight.oneHT.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.dto.RequestPredictionDTO;
import org.springframework.stereotype.Service;

@Service
public class ChurnPredictionService {

    public PredictionResponseDTO predict(RequestPredictionDTO request){
        double probabilidade = Math.random();

        boolean vaiCancelar = probabilidade > 0.5;

        return new PredictionResponseDTO(probabilidade, vaiCancelar);

    }

}
