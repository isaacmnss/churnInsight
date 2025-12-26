package com.churnInsight.oneHT.repository;

import com.churnInsight.oneHT.entity.ChurnPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChurnPredictionRepository extends JpaRepository<ChurnPrediction, Long> {

    long count();

    @Query("SELECT AVG(p.churnProbability) FROM ChurnPrediction p")
    Double findAverageChurnRate();

}
