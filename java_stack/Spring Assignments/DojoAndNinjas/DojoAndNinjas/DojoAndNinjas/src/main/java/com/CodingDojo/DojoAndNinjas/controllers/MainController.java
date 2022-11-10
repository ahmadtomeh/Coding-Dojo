package com.CodingDojo.DojoAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CodingDojo.DojoAndNinjas.models.Dojo;
import com.CodingDojo.DojoAndNinjas.models.Ninja;
import com.CodingDojo.DojoAndNinjas.services.DojoService;
import com.CodingDojo.DojoAndNinjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	NinjaService ninjaService;

	@Autowired
	DojoService dojoService;

	@GetMapping("/ninjas/new")
	public String index(@ModelAttribute("ninjas") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "NewNinja.jsp";
	}

	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, RedirectAttributes redirectAttrs, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Ninja> ninjas = ninjaService.allNinjas();
			model.addAttribute("ninjas", ninjas);
			return "NewNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			redirectAttrs.addAttribute("id", ninja.getDojo());
			return "redirect:/dojos/{id}";
		}
	}

/////////////////////////////////////////////////

	@GetMapping("/dojos/new")
	public String index2(@ModelAttribute("dojos") Dojo dojo, Model model) {
		return "NewDojo.jsp";
	}

	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "NewDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "ShowDojo.jsp";
		}
	}

	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojos = dojoService.findDojo(id);
		model.addAttribute("dojos", dojos);
		return "ShowDojo.jsp";
	}
}
