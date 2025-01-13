package com.example.toureksamen.controllers;

import com.example.toureksamen.models.Rider;
import com.example.toureksamen.repositories.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/riders")
@CrossOrigin(origins = "*")
public class RiderRestController {

    @Autowired
    private RiderRepository riderRepository;

    @PostMapping
    public ResponseEntity<Rider> createRider(@RequestBody Rider rider) {
        try {
            Rider savedRider = riderRepository.save(rider);
            return new ResponseEntity<>(savedRider, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<Rider>> getAllRiders() {
        try {
            List<Rider> riders = riderRepository.findAll();
            if (riders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(riders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a rider by ID
    @GetMapping("/{id}")
    public ResponseEntity<Rider> getRiderById(@PathVariable("id") Long id) {
        Optional<Rider> riderData = riderRepository.findById(id);
        if (riderData.isPresent()) {
            return new ResponseEntity<>(riderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Rider>> getRidersByTeamId(@PathVariable("teamId") Long teamId) {
        List<Rider> riders = riderRepository.findByTeamId(teamId);
        if (riders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(riders, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rider> updateRider(@PathVariable("id") Long id, @RequestBody Rider rider) {
        Optional<Rider> riderData = riderRepository.findById(id);
        if (riderData.isPresent()) {
            Rider updatedRider = riderData.get();
            updatedRider.setFirstName(rider.getFirstName());
            updatedRider.setLastName(rider.getLastName());
            updatedRider.setTeam(rider.getTeam());
            return new ResponseEntity<>(riderRepository.save(updatedRider), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRider(@PathVariable("id") Long id) {
        try {
            riderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/test")
    public ResponseEntity<?> testRider(@RequestBody Map<String, Object> rider) {
        System.out.println("Received JSON: " + rider);
        return ResponseEntity.ok(rider);
    }
}

