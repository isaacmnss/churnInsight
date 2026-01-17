package com.churnInsight.oneHT.application.ports.out;

import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-tools-ds", url = "http://localhost:8000", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface ToolsDSClient {

    @PostMapping(value = "/predict", produces = "application/json")
    PredictionResponseDTO predictClient(@RequestBody RequestPredictionDTO requestPredictionDTO);

}