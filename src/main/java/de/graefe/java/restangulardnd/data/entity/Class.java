package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * The type Class.
 */
@Entity
public class Class implements Serializable {

    @Id
    private Long id;
    @Column(nullable = false)
    private String name = "NaN";
    @JsonIgnore
    @OneToMany(mappedBy = "characterClass")
    private List<DndCharacter> dndCharacters = new ArrayList<DndCharacter>();

    /**
     * Instantiates a new Class.
     *
     * @param name          the name
     * @param dndCharacters the dnd characters
     */
    public Class(
            String name,
            List<DndCharacter> dndCharacters
    ) {
        this.name = name;
        this.dndCharacters = dndCharacters;
    }

    /**
     * Instantiates a new Class.
     */
    public Class() {}

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
