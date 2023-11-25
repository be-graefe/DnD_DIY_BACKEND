package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User.
 */
@Entity
public class User implements Serializable {

    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<DndCharacter> dndCharacters = new ArrayList<>();

    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param password the password
     */
    public User(
            String name,
            String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     */
    public User() {}

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() { return id; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() { return password; }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Gets characters.
     *
     * @return the characters
     */
    public List<DndCharacter> getCharacters() { return dndCharacters; }
}
