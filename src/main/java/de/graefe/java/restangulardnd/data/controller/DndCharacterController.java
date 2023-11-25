package de.graefe.java.restangulardnd.data.controller;

import de.graefe.java.restangulardnd.data.entity.DndCharacter;
import de.graefe.java.restangulardnd.data.exception.NoCharactersExistException;
import de.graefe.java.restangulardnd.data.service.DndCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * The type Dnd character controller.
 */
@RestController
@RequestMapping("/character")
public class DndCharacterController {

    private final DndCharacterService dndCharacterService;

    /**
     * Instantiates a new Dnd character controller.
     *
     * @param dndCharacterService the dnd character service
     */
    @Autowired
    public DndCharacterController(DndCharacterService dndCharacterService) { this.dndCharacterService = dndCharacterService; }

    /**
     * Gets all characters.
     *
     * @return the all characters
     */
    @GetMapping("/all")
    public ResponseEntity<List<DndCharacter>> getAllCharacters() {
        List<DndCharacter> characters = dndCharacterService.getAllCharacters();
        return ResponseEntity.ok(characters);
    }

    /**
     * Gets all characters.
     *
     * @param id the id
     * @return the all characters
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<DndCharacter> getAllCharacters(@PathVariable("id") Long id) {
        try {
            DndCharacter character = dndCharacterService.getCharacter(id);
            return ResponseEntity.ok(character);
        } catch (NoCharactersExistException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/find/user/{userId}")
//    public ResponseEntity<Set<DndCharacter>> getAllCharactersOfUser(@PathVariable("userId") Long userId) {
//        Set<DndCharacter> characters = dndCharacterService.getCharacterByUserId(userId);
//        return ResponseEntity.ok(characters);
//    }

    /**
     * Add character response entity.
     *
     * @param character the character
     * @return the response entity
     */
    @PostMapping("/add")
    public ResponseEntity<DndCharacter> addCharacter(@RequestBody DndCharacter character) {
        DndCharacter newCharacter = dndCharacterService.addCharacter(character);
        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

    /**
     * Update character response entity.
     *
     * @param character the character
     * @return the response entity
     */
    @PutMapping("/update")
    public ResponseEntity<DndCharacter> updateCharacter(@RequestBody DndCharacter character) {
        try {
            DndCharacter newCharacter = dndCharacterService.updateCharacter(character);
            return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
        } catch (NoCharactersExistException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete character response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable("id") Long id) {
        try {
            dndCharacterService.deleteCharacter(id);
            return ResponseEntity.ok().build();
        } catch (NoCharactersExistException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
