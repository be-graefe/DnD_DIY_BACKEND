package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.Weapon;
import de.graefe.java.restangulardnd.data.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Weapon service.
 */
@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    /**
     * Instantiates a new Weapon service.
     *
     * @param weaponRepository the weapon repository
     */
    @Autowired
    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    /**
     * Add weapon weapon.
     *
     * @param weapon the weapon
     * @return the weapon
     */
    public Weapon addWeapon(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    /**
     * Update weapon weapon.
     *
     * @param weapon the weapon
     * @return the weapon
     */
    public Weapon updateWeapon(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    /**
     * Gets weapon.
     *
     * @param id the id
     * @return the weapon
     */
    public Weapon getWeapon(Long id) {
        return weaponRepository.findById(id).orElse(null);
    }

    /**
     * Gets all weapons.
     *
     * @return the all weapons
     */
    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }

    /**
     * Delete weapon.
     *
     * @param id the id
     */
    public void deleteWeapon(Long id) {
        weaponRepository.deleteById(id);
    }
}
