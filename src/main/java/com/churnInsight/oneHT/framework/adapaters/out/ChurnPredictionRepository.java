package com.churnInsight.oneHT.framework.adapaters.out;

import com.churnInsight.oneHT.domain.entity.ChurnPrediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurnPredictionRepository extends JpaRepository<ChurnPrediction, Long> {
}
