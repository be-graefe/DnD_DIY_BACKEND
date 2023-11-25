package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.Language;
import de.graefe.java.restangulardnd.data.entity.Race;
import de.graefe.java.restangulardnd.data.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Race service.
 */
@Service
public class RaceService {

    private final RaceRepository raceRepository;

    /**
     * Instantiates a new Race service.
     *
     * @param raceRepository the race repository
     */
    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    /**
     * Add race race.
     *
     * @param race the race
     * @return the race
     */
    public Race addRace(Race race) {
        return raceRepository.save(race);
    }

    /**
     * Update race race.
     *
     * @param race the race
     * @return the race
     */
    public Race updateRace(Race race) {
        return raceRepository.save(race);
    }

    /**
     * Gets race.
     *
     * @param id the id
     * @return the race
     */
    public Race getRace(Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    /**
     * Gets all races.
     *
     * @return the all races
     */
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    /**
     * Delete race.
     *
     * @param id the id
     */
    public void deleteRace(Long id) {
        raceRepository.deleteById(id);
    }
}
