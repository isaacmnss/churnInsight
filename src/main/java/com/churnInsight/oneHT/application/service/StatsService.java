package com.churnInsight.oneHT.application.service;

import com.churnInsight.oneHT.domain.dto.StatsResponseDTO;
import com.churnInsight.oneHT.framework.adapaters.out.ChurnPredictionRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final ChurnPredictionRepository repository;

    public StatsService(ChurnPredictionRepository repository){
        this.repository = repository;
    }


    public StatsResponseDTO checkStats(){
        return new StatsResponseDTO(repository.count(), repository.findAverageChurnRate());
    }

}
