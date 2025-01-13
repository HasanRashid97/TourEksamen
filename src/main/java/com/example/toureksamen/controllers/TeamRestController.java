package com.example.toureksamen.controllers;

import com.example.toureksamen.models.Team;
import com.example.toureksamen.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "*")
public class TeamRestController {

    @Autowired
    private TeamRepository teamRepository;

    // Get all teams
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    // Get a team by ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id) {
        Optional<Team> teamData = teamRepository.findById(id);
        if (teamData.isPresent()) {
            return new ResponseEntity<>(teamData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new team
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        try {
            Team savedTeam = teamRepository.save(team);
            return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a team by ID
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") Long id, @RequestBody Team team) {
        Optional<Team> teamData = teamRepository.findById(id);
        if (teamData.isPresent()) {
            Team existingTeam = teamData.get();
            existingTeam.setName(team.getName());  // Update the team name
            return new ResponseEntity<>(teamRepository.save(existingTeam), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a team by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable("id") Long id) {
        try {
            teamRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
