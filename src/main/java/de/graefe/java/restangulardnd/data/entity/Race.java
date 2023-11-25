package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Race.
 */
@Entity
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name = "NaN";
    @JsonIgnore
    @OneToMany(mappedBy = "race")
    private List<DndCharacter> dndCharacters = new ArrayList<>();

    /**
     * Instantiates a new Race.
     *
     * @param name          the name
     * @param dndCharacters the dnd characters
     */
    public Race(
            String name,
            List<DndCharacter> dndCharacters
    ) {
        this.name = name;
        this.dndCharacters = dndCharacters;
    }

    /**
     * Instantiates a new Race.
     */
    public Race () {}

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
     * Gets characters.
     *
     * @return the characters
     */
    @JsonIgnore
    public List<DndCharacter> getCharacters() { return dndCharacters; }
}
