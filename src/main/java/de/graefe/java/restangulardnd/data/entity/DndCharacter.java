package de.graefe.java.restangulardnd.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Dnd character.
 */
@Entity
public class DndCharacter implements Serializable {

    @Id
    private Long id;
    private String name;
    private Integer level = 1;
    private Integer proficiencyBonus;
    private Integer armorClass;
    private Integer initiative;
    private Integer speed;
    private Integer maxHitPoints;
    private Integer currentHitPoints;
    private Integer temporaryHitPoints;
    private Integer strength = 10;
    private Integer dexterity = 10;
    private Integer constitution = 10;
    private Integer intelligence = 10;
    private Integer wisdom = 10;
    private Integer charisma = 10;
    private Integer strengthModifier;
    private Integer dexterityModifier;
    private Integer constitutionModifier;
    private Integer intelligenceModifier;
    private Integer wisdomModifier;
    private Integer charismaModifier;
    private Boolean deathSaveSuccess1;
    private Boolean deathSaveSuccess2;
    private Boolean deathSaveSuccess3;
    private Boolean deathSaveFailure1;
    private Boolean deathSaveFailure2;
    private Boolean deathSaveFailure3;
    private Integer gold;
    @Column(length = 1000, columnDefinition = "TEXT")
    private String abilities;
    @Column(length = 1000, columnDefinition = "TEXT")
    private String equipment;
    @ManyToMany
    @JoinTable(name = "learned_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private List<Spell> learnedSpells = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "owned_weapons",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id"))
    private List<Weapon> ownedWeapons = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "learned_languages",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> learnedLanguages = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class characterClass;
    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    private Race race;

    /**
     * Instantiates a new Dnd character.
     *
     * @param name               the name
     * @param learnedSpells      the learned spells
     * @param learnedLanguages   the learned languages
     * @param user               the user
     * @param characterClass     the character class
     * @param race               the race
     * @param level              the level
     * @param proficiencyBonus   the proficiency bonus
     * @param armorClass         the armor class
     * @param initiative         the initiative
     * @param speed              the speed
     * @param maxHitPoints       the max hit points
     * @param currentHitPoints   the current hit points
     * @param temporaryHitPoints the temporary hit points
     * @param strength           the strength
     * @param dexterity          the dexterity
     * @param constitution       the constitution
     * @param intelligence       the intelligence
     * @param wisdom             the wisdom
     * @param charisma           the charisma
     * @param deathSaveSuccess1  the death save success 1
     * @param deathSaveSuccess2  the death save success 2
     * @param deathSaveSuccess3  the death save success 3
     * @param deathSaveFailure1  the death save failure 1
     * @param deathSaveFailure2  the death save failure 2
     * @param deathSaveFailure3  the death save failure 3
     * @param gold               the gold
     * @param abilities          the abilities
     * @param equipment          the equipment
     * @param ownedWeapons       the owned weapons
     */
    public DndCharacter(
        String name,
        List<Spell> learnedSpells,
        List<Language> learnedLanguages,
        User user,
        Class characterClass,
        Race race,
        Integer level,
        Integer proficiencyBonus,
        Integer armorClass,
        Integer initiative,
        Integer speed,
        Integer maxHitPoints,
        Integer currentHitPoints,
        Integer temporaryHitPoints,
        Integer strength,
        Integer dexterity,
        Integer constitution,
        Integer intelligence,
        Integer wisdom,
        Integer charisma,
        Boolean deathSaveSuccess1,
        Boolean deathSaveSuccess2,
        Boolean deathSaveSuccess3,
        Boolean deathSaveFailure1,
        Boolean deathSaveFailure2,
        Boolean deathSaveFailure3,
        Integer gold,
        String abilities,
        String equipment,
        List<Weapon> ownedWeapons
    ) {
        this.name = name;
        this.learnedSpells = learnedSpells;
        this.learnedLanguages = learnedLanguages;
        this.user = user;
        this.characterClass = characterClass;
        this.race = race;
        this.level = level;
        this.proficiencyBonus = proficiencyBonus;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.temporaryHitPoints = temporaryHitPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.strengthModifier = strength % 2 == 0 ? (strength - 10) / 2 : (strength - 11) / 2;
        this.dexterityModifier = dexterity % 2 == 0 ? (dexterity - 10) / 2 : (dexterity - 11) / 2;
        this.constitutionModifier = constitution % 2 == 0 ? (constitution - 10) / 2 : (constitution - 11) / 2;
        this.intelligenceModifier = intelligence % 2 == 0 ? (intelligence - 10) / 2 : (intelligence - 11) / 2;
        this.wisdomModifier = wisdom % 2 == 0 ? (wisdom - 10) / 2 : (wisdom - 11) / 2;
        this.charismaModifier = charisma % 2 == 0 ? (charisma - 10) / 2 : (charisma - 11) / 2;
        this.deathSaveSuccess1 = deathSaveSuccess1;
        this.deathSaveSuccess2 = deathSaveSuccess2;
        this.deathSaveSuccess3 = deathSaveSuccess3;
        this.deathSaveFailure1 = deathSaveFailure1;
        this.deathSaveFailure2 = deathSaveFailure2;
        this.deathSaveFailure3 = deathSaveFailure3;
        this.gold = gold;
        this.abilities = abilities;
        this.equipment = equipment;
        this.ownedWeapons = ownedWeapons;
    }

    /**
     * Instantiates a new Dnd character.
     */
    public DndCharacter() {}

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
     * Gets learned spells.
     *
     * @return the learned spells
     */
    public List<Spell> getLearnedSpells() { return learnedSpells; }

    /**
     * Gets learned languages.
     *
     * @return the learned languages
     */
    public List<Language> getLearnedLanguages() { return learnedLanguages; }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() { return user; }

    /**
     * Gets character class.
     *
     * @return the character class
     */
    public Class getCharacterClass() { return characterClass; }

    /**
     * Gets race.
     *
     * @return the race
     */
    public Race getRace() { return race; }

    /**
     * Gets level.
     *
     * @return the level
     */
    public Integer getLevel() { return level; }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(Integer level) { this.level = level; }

    /**
     * Gets proficiency bonus.
     *
     * @return the proficiency bonus
     */
    public Integer getProficiencyBonus() { return proficiencyBonus; }

    /**
     * Sets proficiency bonus.
     *
     * @param proficiencyBonus the proficiency bonus
     */
    public void setProficiencyBonus(Integer proficiencyBonus) { this.proficiencyBonus = proficiencyBonus; }

    /**
     * Gets armor class.
     *
     * @return the armor class
     */
    public Integer getArmorClass() { return armorClass; }

    /**
     * Sets armor class.
     *
     * @param armorClass the armor class
     */
    public void setArmorClass(Integer armorClass) { this.armorClass = armorClass; }

    /**
     * Gets initiative.
     *
     * @return the initiative
     */
    public Integer getInitiative() { return initiative; }

    /**
     * Sets initiative.
     *
     * @param initiative the initiative
     */
    public void setInitiative(Integer initiative) { this.initiative = initiative; }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public Integer getSpeed() { return speed; }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(Integer speed) { this.speed = speed; }

    /**
     * Gets max hit points.
     *
     * @return the max hit points
     */
    public Integer getMaxHitPoints() { return maxHitPoints; }

    /**
     * Sets max hit points.
     *
     * @param maxHitPoints the max hit points
     */
    public void setMaxHitPoints(Integer maxHitPoints) { this.maxHitPoints = maxHitPoints; }

    /**
     * Gets current hit points.
     *
     * @return the current hit points
     */
    public Integer getCurrentHitPoints() { return currentHitPoints; }

    /**
     * Sets current hit points.
     *
     * @param currentHitPoints the current hit points
     */
    public void setCurrentHitPoints(Integer currentHitPoints) { this.currentHitPoints = currentHitPoints; }

    /**
     * Gets temporary hit points.
     *
     * @return the temporary hit points
     */
    public Integer getTemporaryHitPoints() { return temporaryHitPoints; }

    /**
     * Sets temporary hit points.
     *
     * @param temporaryHitPoints the temporary hit points
     */
    public void setTemporaryHitPoints(Integer temporaryHitPoints) { this.temporaryHitPoints = temporaryHitPoints; }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public Integer getStrength() { return strength; }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(Integer strength) { this.strength = strength; }

    /**
     * Gets dexterity.
     *
     * @return the dexterity
     */
    public Integer getDexterity() { return dexterity; }

    /**
     * Sets dexterity.
     *
     * @param dexterity the dexterity
     */
    public void setDexterity(Integer dexterity) { this.dexterity = dexterity; }

    /**
     * Gets constitution.
     *
     * @return the constitution
     */
    public Integer getConstitution() { return constitution; }

    /**
     * Sets constitution.
     *
     * @param constitution the constitution
     */
    public void setConstitution(Integer constitution) { this.constitution = constitution; }

    /**
     * Gets intelligence.
     *
     * @return the intelligence
     */
    public Integer getIntelligence() { return intelligence; }

    /**
     * Sets intelligence.
     *
     * @param intelligence the intelligence
     */
    public void setIntelligence(Integer intelligence) { this.intelligence = intelligence; }

    /**
     * Gets wisdom.
     *
     * @return the wisdom
     */
    public Integer getWisdom() { return wisdom; }

    /**
     * Sets wisdom.
     *
     * @param wisdom the wisdom
     */
    public void setWisdom(Integer wisdom) { this.wisdom = wisdom; }

    /**
     * Gets charisma.
     *
     * @return the charisma
     */
    public Integer getCharisma() { return charisma; }

    /**
     * Sets charisma.
     *
     * @param charisma the charisma
     */
    public void setCharisma(Integer charisma) { this.charisma = charisma; }

    /**
     * Gets death save success 1.
     *
     * @return the death save success 1
     */
    public Boolean getDeathSaveSuccess1() { return deathSaveSuccess1; }

    /**
     * Sets death save success 1.
     *
     * @param deathSaveSuccess1 the death save success 1
     */
    public void setDeathSaveSuccess1(Boolean deathSaveSuccess1) { this.deathSaveSuccess1 = deathSaveSuccess1; }

    /**
     * Gets death save success 2.
     *
     * @return the death save success 2
     */
    public Boolean getDeathSaveSuccess2() { return deathSaveSuccess2; }

    /**
     * Sets death save success 2.
     *
     * @param deathSaveSuccess2 the death save success 2
     */
    public void setDeathSaveSuccess2(Boolean deathSaveSuccess2) { this.deathSaveSuccess2 = deathSaveSuccess2; }

    /**
     * Gets death save success 3.
     *
     * @return the death save success 3
     */
    public Boolean getDeathSaveSuccess3() { return deathSaveSuccess3; }

    /**
     * Sets death save success 3.
     *
     * @param deathSaveSuccess3 the death save success 3
     */
    public void setDeathSaveSuccess3(Boolean deathSaveSuccess3) { this.deathSaveSuccess3 = deathSaveSuccess3; }

    /**
     * Gets death save failure 1.
     *
     * @return the death save failure 1
     */
    public Boolean getDeathSaveFailure1() { return deathSaveFailure1; }

    /**
     * Sets death save failure 1.
     *
     * @param deathSaveFailure1 the death save failure 1
     */
    public void setDeathSaveFailure1(Boolean deathSaveFailure1) { this.deathSaveFailure1 = deathSaveFailure1; }

    /**
     * Gets death save failure 2.
     *
     * @return the death save failure 2
     */
    public Boolean getDeathSaveFailure2() { return deathSaveFailure2; }

    /**
     * Sets death save failure 2.
     *
     * @param deathSaveFailure2 the death save failure 2
     */
    public void setDeathSaveFailure2(Boolean deathSaveFailure2) { this.deathSaveFailure2 = deathSaveFailure2; }

    /**
     * Gets death save failure 3.
     *
     * @return the death save failure 3
     */
    public Boolean getDeathSaveFailure3() { return deathSaveFailure3; }

    /**
     * Sets death save failure 3.
     *
     * @param deathSaveFailure3 the death save failure 3
     */
    public void setDeathSaveFailure3(Boolean deathSaveFailure3) { this.deathSaveFailure3 = deathSaveFailure3; }

    /**
     * Gets gold.
     *
     * @return the gold
     */
    public Integer getGold() { return gold; }

    /**
     * Sets gold.
     *
     * @param gold the gold
     */
    public void setGold(Integer gold) { this.gold = gold; }

    /**
     * Gets abilities.
     *
     * @return the abilities
     */
    public String getAbilities() { return abilities; }

    /**
     * Sets abilities.
     *
     * @param abilities the abilities
     */
    public void setAbilities(String abilities) { this.abilities = abilities; }

    /**
     * Gets equipment.
     *
     * @return the equipment
     */
    public String getEquipment() { return equipment; }

    /**
     * Sets equipment.
     *
     * @param equipment the equipment
     */
    public void setEquipment(String equipment) { this.equipment = equipment; }

    /**
     * Gets owned weapons.
     *
     * @return the owned weapons
     */
    public List<Weapon> getOwnedWeapons() { return ownedWeapons; }

    /**
     * Gets strength modifier.
     *
     * @return the strength modifier
     */
    public Integer getStrengthModifier() {        return strengthModifier;
    }

    /**
     * Sets strength modifier.
     *
     * @param strengthModifier the strength modifier
     */
    public void setStrengthModifier(Integer strengthModifier) {
        this.strengthModifier = strengthModifier;
    }

    /**
     * Gets dexterity modifier.
     *
     * @return the dexterity modifier
     */
    public Integer getDexterityModifier() {
        return dexterityModifier;
    }

    /**
     * Sets dexterity modifier.
     *
     * @param dexterityModifier the dexterity modifier
     */
    public void setDexterityModifier(Integer dexterityModifier) {
        this.dexterityModifier = dexterityModifier;
    }

    /**
     * Gets constitution modifier.
     *
     * @return the constitution modifier
     */
    public Integer getConstitutionModifier() {
        return constitutionModifier;
    }

    /**
     * Sets constitution modifier.
     *
     * @param constitutionModifier the constitution modifier
     */
    public void setConstitutionModifier(Integer constitutionModifier) {
        this.constitutionModifier = constitutionModifier;
    }

    /**
     * Gets intelligence modifier.
     *
     * @return the intelligence modifier
     */
    public Integer getIntelligenceModifier() {
        return intelligenceModifier;
    }

    /**
     * Sets intelligence modifier.
     *
     * @param intelligenceModifier the intelligence modifier
     */
    public void setIntelligenceModifier(Integer intelligenceModifier) {
        this.intelligenceModifier = intelligenceModifier;
    }

    /**
     * Gets wisdom modifier.
     *
     * @return the wisdom modifier
     */
    public Integer getWisdomModifier() {
        return wisdomModifier;
    }

    /**
     * Sets wisdom modifier.
     *
     * @param wisdomModifier the wisdom modifier
     */
    public void setWisdomModifier(Integer wisdomModifier) {
        this.wisdomModifier = wisdomModifier;
    }

    /**
     * Gets charisma modifier.
     *
     * @return the charisma modifier
     */
    public Integer getCharismaModifier() {
        return charismaModifier;
    }

    /**
     * Sets charisma modifier.
     *
     * @param charismaModifier the charisma modifier
     */
    public void setCharismaModifier(Integer charismaModifier) {
        this.charismaModifier = charismaModifier;
    }
}
