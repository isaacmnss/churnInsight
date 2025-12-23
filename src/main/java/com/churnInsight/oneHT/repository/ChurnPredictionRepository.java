package com.churnInsight.oneHT.repository;

import com.churnInsight.oneHT.entity.ChurnPrediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurnPredictionRepository extends JpaRepository<ChurnPrediction, Long> {
}
