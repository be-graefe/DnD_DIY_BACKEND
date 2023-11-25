package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Language.
 */
@Entity
public class Language implements Serializable {

    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "learnedLanguages")
    private List<DndCharacter> learnedBy = new ArrayList<>();

    /**
     * Instantiates a new Language.
     *
     * @param name      the name
     * @param learnedBy the learned by
     */
    public Language(
            String name,
            List<DndCharacter> learnedBy
    ) {
        this.name = name;
        this.learnedBy = learnedBy;
    }

    /**
     * Instantiates a new Language.
     */
    public Language() {}

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
     * Gets learned by.
     *
     * @return the learned by
     */
    public List<DndCharacter> getLearnedBy() { return learnedBy; }
}
