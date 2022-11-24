package com.CodingDojo.JavaExam.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodingDojo.JavaExam.models.LoginUser;
import com.CodingDojo.JavaExam.models.Team;
import com.CodingDojo.JavaExam.models.User;
import com.CodingDojo.JavaExam.repositories.UserRepository;
import com.CodingDojo.JavaExam.services.TeamService;
import com.CodingDojo.JavaExam.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TeamService teamService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "LogReg.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "LogReg.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "LogReg.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}

	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);

		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Long user_id = (Long) session.getAttribute("user_id");
			User thisUser = userServ.findUserById(user_id);
			List<Team> teams = teamService.allTeams();
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("teams", teams);
			return "Success.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/teams/new")
	public String index(@ModelAttribute("team") Team team, Model model, HttpSession session) {
		User user=userServ.findUserById((Long) session.getAttribute("user_id"));
		session.setAttribute("thisUser", user);
		return "NewTeam.jsp";
	}
	
	@PostMapping("/teams/new")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result,HttpSession session, Model model) {
		if (result.hasErrors()) {
			List<Team> teams = teamService.allTeams();
			model.addAttribute("teams", teams);
			return "NewTeam.jsp";
		} else {
			User user=userServ.findUserById((Long) session.getAttribute("user_id"));
			session.setAttribute("thisUser", user);
			teamService.createTeam(team);
	    	List<User> users=new ArrayList<User>();
	    	users.add(user);
	    	team.setUserjoin(users);
	    	teamService.updateTeam(team);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/teams/{id}/edit")
	public String index2( Model model, HttpSession session,@PathVariable("id")Long id ) {
		List<Team> teams = teamService.allTeams();
		Team pro = teamService.findTeam(id);
		model.addAttribute("pro", pro);
		model.addAttribute("teams", teams);
		return "EditTeam.jsp";
	}
	
	@PutMapping("/teams/{id}/edit")
	public String edit(@Valid @ModelAttribute("pro") Team team, BindingResult result, @PathVariable("id")Long id, Model model) {
		Team teams = teamService.findTeam(id);
		List<User> pppp = teams.getUserjoin();
		if (result.hasErrors()) {
			model.addAttribute("teams", teams);
			return "EditTeam.jsp";
		} else {
			team.setUserjoin(pppp);
			teamService.createTeam(team);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/teams/{id}/delete")
	public String destroy2(@PathVariable("id") Long id) {
		teamService.deleteTeam(id);
		return "redirect:/home";
	}
	
	@GetMapping("/teams/{id}")
	public String show(@PathVariable(required = false) Long id, @ModelAttribute("team") Team team, Model model,
			HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		Team thisTeam = teamService.findTeam(id);
		User thisUser = userServ.findUserById(user_id);
		List <User> users = userServ.getUsersNotfor(team);
        model.addAttribute("thisUser", thisUser);
		model.addAttribute("teams", thisTeam);
		model.addAttribute("users", users);
		model.addAttribute("teams2", thisTeam.getUserjoin());
		return "ShowTeam.jsp";
	}
	
	
	@RequestMapping("/join/{tId}")
	public String join(@PathVariable("tId") Long id1, @RequestParam("user1") Long id2 ,HttpSession session) {
		User thisUser = userServ.findUserById(id2);
		Team pro = teamService.findTeam(id1);
		pro.getUserjoin().add(thisUser);
		teamService.updateTeam(pro);
		return "redirect:/teams/" + id1;
	}

}