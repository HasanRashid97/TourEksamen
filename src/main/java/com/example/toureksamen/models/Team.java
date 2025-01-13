package com.example.toureksamen.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Team {

    public Team() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rider> riders;


    public Long getId() {
        return id;
    }

    public void setId(Long teamId) {
        this.id = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }


}



