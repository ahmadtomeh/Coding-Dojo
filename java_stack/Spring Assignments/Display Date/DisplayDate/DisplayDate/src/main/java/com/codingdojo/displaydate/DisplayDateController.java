package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("EEEE, 'the' dd 'of ' MMMM, yyyy");
		String stringDate = DateFor.format(date);
		model.addAttribute("date", stringDate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("hh:mm aa");
		String stringDate = DateFor.format(date);
		model.addAttribute("date", stringDate);
		return "time.jsp";
	}

}
