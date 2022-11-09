package com.CodingDojo.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.CodingDojo.Languages.models.Language;
import com.CodingDojo.Languages.services.LanguageService;

@Controller
public class LanguagesController {
	@Autowired
	LanguageService languageService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Language languages = languageService.findLanguage(id);
        model.addAttribute("languages", languages);
        return "show.jsp";
    }
	
	@GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
		Language languages = languageService.findLanguage(id);
        model.addAttribute("languages", languages);
        return "edit.jsp";
    }
    
    @PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("languages") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
