package com.churnInsight.oneHT.framework.adapters.in;

import com.churnInsight.oneHT.application.service.ChurnPredictionServiceIMPL;
import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/prediction")
public class ChurnPredictionController {

    private ChurnPredictionServiceIMPL service;

    @PostMapping
    public ResponseEntity<PredictionResponseDTO> predict(@Valid @RequestBody RequestPredictionDTO request) {
        return ResponseEntity.ok(service.predict(request));
    }

}
