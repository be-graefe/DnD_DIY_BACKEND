package de.graefe.java.restangulardnd.data.repository;

import de.graefe.java.restangulardnd.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Weapon repository.
 */
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
