package com.churnInsight.oneHT.application.service;

import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import com.churnInsight.oneHT.domain.entity.ChurnPrediction;
import com.churnInsight.oneHT.framework.adapters.out.ChurnPredictionRepository;
import com.churnInsight.oneHT.framework.exceptions.ExceptionNegocio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChurnPredictionService {


    private final ChurnPredictionRepository repository;

    public ChurnPredictionService(ChurnPredictionRepository repository){
        this.repository = repository;
    }

    public PredictionResponseDTO predict(RequestPredictionDTO request){

        if(request.age()< 18){
            throw new ExceptionNegocio("Cliente deve ser maior de idade");
        }



        double probabilidade = Math.random();

        boolean vaiCancelar = probabilidade > 0.5;


        ChurnPrediction prediction = ChurnPrediction.builder()
                .creditScore(request.creditScore())
                .geography(request.geography())
                .gender(request.gender())
                .age(request.age())
                .tenure(request.tenure())
                .balance(request.balance())
                .numOfProducts(request.numOfProducts())
                .hasCrCard(request.hasCrCard())
                .isActiveMember(request.isActiveMember())
                .estimatedSalary(request.estimatedSalary())
                .pointEarned(request.pointEarned())
                .cardType(request.cardType())
                .churnProbability(probabilidade)
                .churn(vaiCancelar)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(prediction);


        return new PredictionResponseDTO(probabilidade, vaiCancelar, prediction.getCreatedAt());

    }

}
