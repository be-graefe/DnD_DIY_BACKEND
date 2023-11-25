package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.Class;
import de.graefe.java.restangulardnd.data.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Class service.
 */
@Service
public class ClassService {

    private final ClassRepository classRepository;

    /**
     * Instantiates a new Class service.
     *
     * @param classRepository the class repository
     */
    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    /**
     * Add class class.
     *
     * @param characterClass the character class
     * @return the class
     */
    public Class addClass(Class characterClass) {
        return classRepository.save(characterClass);
    }

    /**
     * Update class class.
     *
     * @param characterClass the character class
     * @return the class
     */
    public Class updateClass(Class characterClass) {
        return classRepository.save(characterClass);
    }

    /**
     * Gets class.
     *
     * @param id the id
     * @return the class
     */
    public Class getClass(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    /**
     * Gets all classes.
     *
     * @return the all classes
     */
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    /**
     * Delete class.
     *
     * @param id the id
     */
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
