package com.CodingDojo.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CodingDojo.Languages.models.Language;
import com.CodingDojo.Languages.repositories.LanguageRepository;
@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService (LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguages = languageRepository.findById(id);
		if (optionalLanguages.isPresent()) {
			return optionalLanguages.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguages = languageRepository.findById(id);
		if (optionalLanguages.isPresent()) {
			languageRepository.deleteById(id);
		}
	}
}
