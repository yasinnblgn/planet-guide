 package com.example.planetguide.service;

import com.example.planetguide.entity.Planet;
import com.example.planetguide.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public Optional<Planet> getPlanetById(Long id) {
        return planetRepository.findById(id);
    }

    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public void deletePlanet(Long id) {
        planetRepository.deleteById(id);
    }
}
