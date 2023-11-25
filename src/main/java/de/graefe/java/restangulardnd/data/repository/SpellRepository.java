package de.graefe.java.restangulardnd.data.repository;

import de.graefe.java.restangulardnd.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Spell repository.
 */
public interface SpellRepository extends JpaRepository<Spell, Long> {
}
