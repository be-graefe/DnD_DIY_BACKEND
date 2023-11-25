package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.DndCharacter;
import de.graefe.java.restangulardnd.data.entity.User;
import de.graefe.java.restangulardnd.data.exception.NoCharactersExistException;
import de.graefe.java.restangulardnd.data.exception.UserAlreadyExistsException;
import de.graefe.java.restangulardnd.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * The type User service.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Add user user.
     *
     * @param user the user
     * @return the user
     */
    public User addUser(User user) {
        if (userRepository.getNextId() == null) {
            user.setId(1L);
        } else {
            user.setId(userRepository.getNextId() + 1);
        }
        return userRepository.save(user);
    }

    /**
     * Update user user.
     *
     * @param user the user
     * @return the user
     */
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Gets user.
     *
     * @param name the name
     * @return the user
     */
    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    /**
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    public User getUserByUsername(String username) {
        return userRepository.findByName(username);
    }

    /**
     * Delete user.
     *
     * @param id the id
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
