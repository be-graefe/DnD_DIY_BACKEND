package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Spell.
 */
@Entity
public class Spell implements Serializable {

    @Id
    private Long id;
    private String name;
    private Integer tier;
    private String damage;
    @Column(length = 1000, columnDefinition = "TEXT")
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "learnedSpells")
    private List<DndCharacter> learnedBy = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "damage_type_id", referencedColumnName = "id")
    private DamageType spellDamageType;

    /**
     * Instantiates a new Spell.
     *
     * @param name        the name
     * @param tier        the tier
     * @param damage      the damage
     * @param description the description
     * @param learnedBy   the learned by
     * @param damageType  the damage type
     */
    public Spell(
            String name,
            Integer tier,
            String damage,
            String description,
            List<DndCharacter> learnedBy,
            DamageType damageType
    ) {
        this.name = name;
        this.tier = tier;
        this.damage = damage;
        this.description = description;
        this.learnedBy = learnedBy;
        this.spellDamageType = damageType;
    }

    /**
     * Instantiates a new Spell.
     */
    public Spell() {}

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

    /**
     * Gets damage type.
     *
     * @return the damage type
     */
    public DamageType getDamageType() { return spellDamageType; }

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
     * Gets tier.
     *
     * @return the tier
     */
    public Integer getTier() { return tier; }

    /**
     * Sets tier.
     *
     * @param tier the tier
     */
    public void setTier(Integer tier) { this.tier = tier; }
}
