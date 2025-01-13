package com.example.toureksamen.models;

import jakarta.persistence.*;

@Entity
public class Result {

    public Result() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "rider_id", nullable = false)
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    @Column(nullable = false)
    private int timeSeconds;

    @Column(nullable = false)
    private int sprintPoints;

    @Column(nullable = false)
    private int mountainPoints;

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public int getSprintPoints() {
        return sprintPoints;
    }

    public void setSprintPoints(int sprintPoints) {
        this.sprintPoints = sprintPoints;
    }

    public int getMountainPoints() {
        return mountainPoints;
    }

    public void setMountainPoints(int mountainPoints) {
        this.mountainPoints = mountainPoints;
    }

}


