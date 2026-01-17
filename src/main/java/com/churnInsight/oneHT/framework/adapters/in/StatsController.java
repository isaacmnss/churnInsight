package com.churnInsight.oneHT.framework.adapters.in;

import com.churnInsight.oneHT.domain.dto.StatsResponseDTO;
import com.churnInsight.oneHT.application.service.StatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/stats")
@Tag(name = "Stats", description = "Endpoint de estatísticas")
public class StatsController {

    @Autowired
    private StatsService service;

    @GetMapping
    @Operation(summary = "Retornar clientes e churn médio")
    public ResponseEntity<StatsResponseDTO> checkStats(){
        return ResponseEntity.ok(service.checkStats());
    }


}
