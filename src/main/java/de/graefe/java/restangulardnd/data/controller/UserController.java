package de.graefe.java.restangulardnd.data.controller;

import de.graefe.java.restangulardnd.data.entity.DndCharacter;
import de.graefe.java.restangulardnd.data.entity.User;
import de.graefe.java.restangulardnd.data.exception.NoCharactersExistException;
import de.graefe.java.restangulardnd.data.exception.UserAlreadyExistsException;
import de.graefe.java.restangulardnd.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    /**
     * Add user response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User newUser = userService.addUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Gets user.
     *
     * @param name the name
     * @return the user
     */
    @GetMapping("/find/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        User user = userService.getUser(name);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
