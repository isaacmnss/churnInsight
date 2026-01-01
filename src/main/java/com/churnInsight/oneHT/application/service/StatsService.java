package com.churnInsight.oneHT.service;

import com.churnInsight.oneHT.dto.StatsResponseDTO;
import com.churnInsight.oneHT.repository.ChurnPredictionRepository;
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
