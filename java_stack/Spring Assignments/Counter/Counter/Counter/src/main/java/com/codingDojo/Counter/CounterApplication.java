package com.codingDojo.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
		@RequestMapping("/")
		public String index(HttpSession session) {

			// If the count is not already in session
			if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
			} else {
				Integer currentCount = (Integer) session.getAttribute("count");
				currentCount++;
				session.setAttribute("count", currentCount);
			}
			return "index.jsp";
		}
		
		@RequestMapping("/zero")
		public String index2(HttpSession session) {
				session.setAttribute("count", 0);
			return "counter.jsp";
		}
		
		@RequestMapping("/counter")
		public String showCount(HttpSession session, Model model) {
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
			return "counter.jsp";
		}
		@RequestMapping("/add2")
		public String showCounter(HttpSession session, Model model) {
			if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
			} else {
				Integer currentCounter = (Integer) session.getAttribute("count");
				currentCounter+=2;
				session.setAttribute("count", currentCounter);
			}
			return "counter2.jsp";
		}

}
