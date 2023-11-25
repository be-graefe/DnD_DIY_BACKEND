package de.graefe.java.restangulardnd.data.repository;

import de.graefe.java.restangulardnd.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);

    /**
     * Gets next id.
     *
     * @return the next id
     */
    @Query(value = "SELECT MAX(id) FROM User")
    Long getNextId();
}
