package com.example.toureksamen.models;

import com.example.toureksamen.misc.JerseyType;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class JerseyStanding {

    public JerseyStanding (){}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private JerseyType jerseyType;

    @ManyToOne
    @JoinColumn(name = "rider_id", nullable = false)
    private Rider rider;

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


}

