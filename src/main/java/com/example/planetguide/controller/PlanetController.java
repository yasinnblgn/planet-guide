package com.example.planetguide.controller;

import com.example.planetguide.entity.Planet;
import com.example.planetguide.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planets")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public List<Planet> getAllPlanets() {
        return planetService.getAllPlanets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable Long id) {
        Optional<Planet> planet = planetService.getPlanetById(id);
        return planet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Planet createPlanet(@RequestBody Planet planet) {
        return planetService.savePlanet(planet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable Long id, @RequestBody Planet newPlanet) {
        return planetService.getPlanetById(id)
                .map(existingPlanet -> {
                    existingPlanet.setName(newPlanet.getName());
                    existingPlanet.setMass(newPlanet.getMass());
                    existingPlanet.setDiameter(newPlanet.getDiameter());
                    existingPlanet.setNumberOfMoons(newPlanet.getNumberOfMoons());
                    existingPlanet.setDescription(newPlanet.getDescription());
                    planetService.savePlanet(existingPlanet);
                    return ResponseEntity.ok(existingPlanet);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable Long id) {
        if (planetService.getPlanetById(id).isPresent()) {
            planetService.deletePlanet(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}