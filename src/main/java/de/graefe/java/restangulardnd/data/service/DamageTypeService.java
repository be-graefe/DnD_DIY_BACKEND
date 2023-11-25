package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.DamageType;
import de.graefe.java.restangulardnd.data.repository.DamageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Damage type service.
 */
@Service
public class DamageTypeService {

    private final DamageTypeRepository damageTypeRepository;

    /**
     * Instantiates a new Damage type service.
     *
     * @param damageTypeRepository the damage type repository
     */
    @Autowired
    public DamageTypeService(DamageTypeRepository damageTypeRepository) { this.damageTypeRepository = damageTypeRepository; }

    /**
     * Add damage type damage type.
     *
     * @param damageType the damage type
     * @return the damage type
     */
    public DamageType addDamageType(DamageType damageType) {
        return damageTypeRepository.save(damageType);
    }

    /**
     * Update damage type damage type.
     *
     * @param damageType the damage type
     * @return the damage type
     */
    public DamageType updateDamageType(DamageType damageType) {
        return damageTypeRepository.save(damageType);
    }

    /**
     * Gets damage type.
     *
     * @param id the id
     * @return the damage type
     */
    public DamageType getDamageType(Long id) {
        return damageTypeRepository.findById(id).orElse(null);
    }

    /**
     * Gets all damage types.
     *
     * @return the all damage types
     */
    public List<DamageType> getAllDamageTypes() {
        return damageTypeRepository.findAll();
    }

    /**
     * Delete damage type.
     *
     * @param id the id
     */
    public void deleteDamageType(Long id) {
        damageTypeRepository.deleteById(id);
    }
}
