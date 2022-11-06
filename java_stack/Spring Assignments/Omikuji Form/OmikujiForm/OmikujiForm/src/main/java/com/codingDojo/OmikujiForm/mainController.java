package com.codingDojo.OmikujiForm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class mainController {
	@RequestMapping("/")
	public String auto() {
		return "redirect:/omikuji";
	}

	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/git")
	public String show(@RequestParam(value = "year") String year, @RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person, @RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "living") String living, @RequestParam(value = "something") String something,
			HttpSession session) {
		session.setAttribute("city", city);
		session.setAttribute("year", year);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("something", something);
		return "redirect:/show";
	}

	@RequestMapping("/show")
	public String home() {
		return "show.jsp";

	}
}
