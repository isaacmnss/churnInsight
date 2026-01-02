package com.churnInsight.oneHT.domain.entity;

import com.churnInsight.oneHT.domain.Enum.CardType;
import com.churnInsight.oneHT.domain.Enum.Gender;
import com.churnInsight.oneHT.domain.Enum.Geography;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "previsao_churn")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChurnPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer creditScore;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Geography geography;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Integer tenure;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private Integer numOfProducts;

    @Column(nullable = false)
    private boolean hasCrCard;

    @Column(nullable = false)
    private boolean isActiveMember;

    @Column(nullable = false)
    private Double estimatedSalary;

    @Column(nullable = false)
    private Integer pointEarned;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(nullable = false)
    private Double churnProbability;

    @Column(nullable = false)
    private Boolean churn;

    @Column(nullable = false)
    private LocalDateTime createdAt;


}
