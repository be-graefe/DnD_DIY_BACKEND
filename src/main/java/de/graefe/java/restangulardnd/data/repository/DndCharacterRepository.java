package de.graefe.java.restangulardnd.data.repository;

import de.graefe.java.restangulardnd.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;

/**
 * The interface Dnd character repository.
 */
public interface DndCharacterRepository extends JpaRepository<DndCharacter, Long> {
    /**
     * Gets next id.
     *
     * @return the next id
     */
    @Query(value = "SELECT MAX(id) FROM DndCharacter")
    Long getNextId();

    /**
     * Find by user id hash set.
     *
     * @param userId the user id
     * @return the hash set
     */
    HashSet<DndCharacter> findByUserId(Long userId);
}
