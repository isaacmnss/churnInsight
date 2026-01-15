package com.churnInsight.oneHT.framework.adapters.in;

import com.churnInsight.oneHT.application.service.ChurnPredictionServiceIMPL;
import com.churnInsight.oneHT.domain.dto.PredictionResponseDTO;
import com.churnInsight.oneHT.domain.dto.RequestPredictionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Predictions", description = "Endpoint de previsão de churn")
public class ChurnPredictionController {

    private ChurnPredictionServiceIMPL service;

    @Operation(summary = "Realizar previsão de churn")
    @PostMapping
    public ResponseEntity<PredictionResponseDTO> predict(@Valid @RequestBody RequestPredictionDTO request) {
        return ResponseEntity.ok(service.predict(request));
    }

}
