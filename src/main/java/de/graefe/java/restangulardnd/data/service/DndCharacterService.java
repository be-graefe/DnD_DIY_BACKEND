package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.DndCharacter;
import de.graefe.java.restangulardnd.data.exception.NoCharactersExistException;
import de.graefe.java.restangulardnd.data.repository.DndCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * The type Dnd character service.
 */
@Service
public class DndCharacterService {

    private final DndCharacterRepository dndCharacterRepository;

    /**
     * Instantiates a new Dnd character service.
     *
     * @param dndCharacterRepository the dnd character repository
     */
    @Autowired
    public DndCharacterService(DndCharacterRepository dndCharacterRepository) { this.dndCharacterRepository = dndCharacterRepository; }

    /**
     * Add character dnd character.
     *
     * @param character the character
     * @return the dnd character
     */
    public DndCharacter addCharacter(DndCharacter character) {
        if (dndCharacterRepository.getNextId() == null) {
            character.setId(1L);
        } else {
            character.setId(dndCharacterRepository.getNextId() + 1);
        }
        return dndCharacterRepository.save(character);
    }

    /**
     * Gets all characters.
     *
     * @return the all characters
     */
    public List<DndCharacter> getAllCharacters() {
        return dndCharacterRepository.findAll();
    }

    /**
     * Update character dnd character.
     *
     * @param character the character
     * @return the dnd character
     */
    public DndCharacter updateCharacter(DndCharacter character) {
        if (dndCharacterRepository.findById(character.getId()).isPresent()) {
            return dndCharacterRepository.save(character);
        } else {
            throw new NoCharactersExistException();
        }
    }

    /**
     * Gets character.
     *
     * @param id the id
     * @return the character
     */
    public DndCharacter getCharacter(Long id) {
        return dndCharacterRepository.findById(id).orElseThrow(NoCharactersExistException::new);
    }

    /**
     * Gets character by user id.
     *
     * @param userId the user id
     * @return the character by user id
     */
    public Set<DndCharacter> getCharacterByUserId(Long userId) {
        return dndCharacterRepository.findByUserId(userId);
    }

    /**
     * Delete character.
     *
     * @param id the id
     */
    public void deleteCharacter(Long id) {
        if (dndCharacterRepository.findById(id).isPresent()) {
            dndCharacterRepository.deleteById(id);
        } else {
            throw new NoCharactersExistException();
        }
    }
}
