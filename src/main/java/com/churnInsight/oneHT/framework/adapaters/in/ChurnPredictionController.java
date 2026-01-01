package com.churnInsight.oneHT.controller;

import com.churnInsight.oneHT.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.dto.RequestPredictionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.churnInsight.oneHT.service.ChurnPredictionService;

@RestController
@RequestMapping("/v1/predict")
public class ChurnPredictionController {

    @Autowired
    private ChurnPredictionService service;

    @PostMapping
    public ResponseEntity<PredictionResponseDTO> predict(@Valid @RequestBody RequestPredictionDTO request){
        return ResponseEntity.ok(service.predict(request));
    }


}
