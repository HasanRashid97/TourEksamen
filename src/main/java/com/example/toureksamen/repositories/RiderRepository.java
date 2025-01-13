package com.example.toureksamen.repositories;

import com.example.toureksamen.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider, Long> {
    List<Rider> findByTeamId(Long teamId);
}
