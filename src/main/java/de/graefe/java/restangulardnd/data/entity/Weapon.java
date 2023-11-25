package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Weapon.
 */
@Entity
public class Weapon implements Serializable {

    @Id
    private Long id;
    private String name;
    private String damage;
    @Column(length = 1000, columnDefinition = "TEXT")
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "ownedWeapons")
    private List<DndCharacter> learnedBy = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "damage_type_id", referencedColumnName = "id")
    private DamageType damageType;

    /**
     * Instantiates a new Weapon.
     *
     * @param name        the name
     * @param damage      the damage
     * @param description the description
     * @param learnedBy   the learned by
     * @param damageType  the damage type
     */
    public Weapon(
            String name,
            String damage,
            String description,
            List<DndCharacter> learnedBy,
            DamageType damageType
    ) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.learnedBy = learnedBy;
        this.damageType = damageType;
    }

    /**
     * Instantiates a new Weapon.
     */
    public Weapon() {}

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
     * Gets damage.
     *
     * @return the damage
     */
    public String getDamage() { return damage; }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(String damage) { this.damage = damage; }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() { return description; }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets learned by.
     *
     * @return the learned by
     */
    public List<DndCharacter> getLearnedBy() { return learnedBy; }

    /**
     * Gets damage type.
     *
     * @return the damage type
     */
    public DamageType getDamageType() { return damageType; }
}
