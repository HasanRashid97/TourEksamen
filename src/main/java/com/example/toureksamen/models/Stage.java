package com.example.toureksamen.models;

import jakarta.persistence.*;

@Entity
public class Stage {

    public Stage() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stageId;

    @Column(nullable = false)
    private int stageNumber;

    @Column(nullable = false)
    private double distanceKm;

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }


}
