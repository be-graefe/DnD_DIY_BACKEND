package de.graefe.java.restangulardnd.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.graefe.java.restangulardnd.data.entity.Class;

/**
 * The interface Class repository.
 */
public interface ClassRepository extends JpaRepository<Class, Long> {
}
