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
 * The type Damage type.
 */
@Entity
public class DamageType implements Serializable {

    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "spellDamageType")
    private List<Spell> spells = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "damageType")
    private List<Weapon> weapons = new ArrayList<>();

    /**
     * Instantiates a new Damage type.
     *
     * @param name    the name
     * @param spells  the spells
     * @param weapons the weapons
     */
    public DamageType(
            String name,
            List<Spell> spells,
            List<Weapon> weapons
    ) {
        this.name = name;
        this.spells = spells;
        this.weapons = weapons;
    }

    /**
     * Instantiates a new Damage type.
     */
    public DamageType() {}

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
     * Gets spells.
     *
     * @return the spells
     */
    public List<Spell> getSpells() { return spells; }

    /**
     * Gets weapons.
     *
     * @return the weapons
     */
    public List<Weapon> getWeapons() { return weapons; }
}
