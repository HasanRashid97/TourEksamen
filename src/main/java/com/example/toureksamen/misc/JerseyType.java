package com.example.toureksamen.misc;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class JerseyStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private JerseyType jerseyType;

    @ManyToOne
    @JoinColumn(name = "rider_id", nullable = false)
    private Rider rider;

    private Integer totalTime; // In seconds, for yellow/white jerseys
    private Integer totalSprintPoints; // For green jersey
    private Integer totalMountainPoints; // For polka-dot jersey

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JerseyType getJerseyType() {
        return jerseyType;
    }

    public void setJerseyType(JerseyType jerseyType) {
        this.jerseyType = jerseyType;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTotalSprintPoints() {
        return totalSprintPoints;
    }

    public void setTotalSprintPoints(Integer totalSprintPoints) {
        this.totalSprintPoints = totalSprintPoints;
    }

    public Integer getTotalMountainPoints() {
        return totalMountainPoints;
    }

    public void setTotalMountainPoints(Integer totalMountainPoints) {
        this.totalMountainPoints = totalMountainPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JerseyStanding that = (JerseyStanding) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
