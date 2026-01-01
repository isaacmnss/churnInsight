package com.churnInsight.oneHT.framework.adapaters.out;

import com.churnInsight.oneHT.domain.entity.ChurnPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChurnPredictionRepository extends JpaRepository<ChurnPrediction, Long> {

    long count();

    @Query("SELECT AVG(p.churnProbability) FROM ChurnPrediction p")
    Double findAverageChurnRate();

}
