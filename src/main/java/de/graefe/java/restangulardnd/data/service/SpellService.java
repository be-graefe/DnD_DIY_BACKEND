package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.Spell;
import de.graefe.java.restangulardnd.data.repository.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Spell service.
 */
@Service
public class SpellService {

    private final SpellRepository spellRepository;

    /**
     * Instantiates a new Spell service.
     *
     * @param spellRepository the spell repository
     */
    @Autowired
    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    /**
     * Add spell spell.
     *
     * @param spell the spell
     * @return the spell
     */
    public Spell addSpell(Spell spell) {
        return spellRepository.save(spell);
    }

    /**
     * Update spell spell.
     *
     * @param spell the spell
     * @return the spell
     */
    public Spell updateSpell(Spell spell) {
        return spellRepository.save(spell);
    }

    /**
     * Gets spell.
     *
     * @param id the id
     * @return the spell
     */
    public Spell getSpell(Long id) {
        return spellRepository.findById(id).orElse(null);
    }

    /**
     * Gets all spells.
     *
     * @return the all spells
     */
    public List<Spell> getAllSpells() {
        return spellRepository.findAll();
    }

    /**
     * Delete spell.
     *
     * @param id the id
     */
    public void deleteSpell(Long id) {
        spellRepository.deleteById(id);
    }
}
