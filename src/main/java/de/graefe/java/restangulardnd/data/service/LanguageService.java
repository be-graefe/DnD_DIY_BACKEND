package de.graefe.java.restangulardnd.data.service;

import de.graefe.java.restangulardnd.data.entity.Language;
import de.graefe.java.restangulardnd.data.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Language service.
 */
@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    /**
     * Instantiates a new Language service.
     *
     * @param languageRepository the language repository
     */
    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    /**
     * Add language language.
     *
     * @param language the language
     * @return the language
     */
    public Language addLanguage(Language language) {
        return languageRepository.save(language);
    }

    /**
     * Update language language.
     *
     * @param language the language
     * @return the language
     */
    public Language updateLanguage(Language language) {
        return languageRepository.save(language);
    }

    /**
     * Gets language.
     *
     * @param id the id
     * @return the language
     */
    public Language getLanguage(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    /**
     * Gets all languages.
     *
     * @return the all languages
     */
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    /**
     * Delete language.
     *
     * @param id the id
     */
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
