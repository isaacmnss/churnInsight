package com.churnInsight.oneHT.framework.adapaters.in;

import com.churnInsight.oneHT.application.service.ChurnPredictionService;
import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
