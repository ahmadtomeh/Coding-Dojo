package com.codingDojo.NinjaGoldGame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {

			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}

	@RequestMapping("/")
	public String start() {
		return "redirect:/gold";
	}

	@RequestMapping("/process_money")
	public String index(Model model, @RequestParam(value = "which") String which, HttpSession session) {
		Random randMachine = new Random();
		int rand_int1 = randMachine.nextInt(10, 21);
		int rand_int2 = randMachine.nextInt(-50, 51);
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
		String stringDate = DateFor.format(date);
		if (session.getAttribute("msg") == null) {
			ArrayList<String> msg = new ArrayList<String>();
			session.setAttribute("msg", msg);
		}
		ArrayList<String> msg = new ArrayList<String>();
		msg = (ArrayList<String>) session.getAttribute("msg");
		
		
		if (which.equals("Quest")) {
			if (session.getAttribute("gold") == null) {
				session.setAttribute("gold", 0);
			} else {
				Integer x = (Integer) session.getAttribute("gold");
				x += rand_int2;
				session.setAttribute("gold", x);
				System.out.println(rand_int2);
			}
			
			
			if (rand_int2 < 0) {
				msg.add(0,"You failed a " + which + " and lost " + (rand_int2 * -1) + " gold. Ouch. " + stringDate);
				System.out.println(msg);
			} else {
				msg.add(0,"You completed a " + which + " and earned " + rand_int2 + " gold. " + stringDate);
				System.out.println(msg);
			}
			
			
		} else {
			
			
			if (session.getAttribute("gold") == null) {
				session.setAttribute("gold", 0);
			} else {
				Integer x = (Integer) session.getAttribute("gold");
				x += rand_int1;
				session.setAttribute("gold", x);
				System.out.println(rand_int1);
			}
			msg.add("You completed a " + which + " and earned " + rand_int1 + " gold. " + stringDate);
			session.setAttribute("msg1", msg);
			System.out.println(session.getAttribute("msg"));
		}
		return "redirect:/gold";
	}

}
