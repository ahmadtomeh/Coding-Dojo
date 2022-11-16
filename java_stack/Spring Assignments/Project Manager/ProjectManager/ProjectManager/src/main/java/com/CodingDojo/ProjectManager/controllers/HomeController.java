package com.CodingDojo.ProjectManager.controllers;

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

import com.CodingDojo.ProjectManager.models.LoginUser;
import com.CodingDojo.ProjectManager.models.Project;
import com.CodingDojo.ProjectManager.models.User;
import com.CodingDojo.ProjectManager.repositories.UserRepository;
import com.CodingDojo.ProjectManager.services.ProjectService;
import com.CodingDojo.ProjectManager.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProjectService projectService;

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

//	@GetMapping("/home")
//	public String home(Model model, HttpSession session) {
//		if (session.getAttribute("user_id") != null) {
//			Long user_id = (Long) session.getAttribute("user_id");
//			User thisUser = userServ.findUserById(user_id);
//			List<Project> joined = projectService.joined(thisUser);
//			List<Project> projects = projectService.notjoin();
//			model.addAttribute("projects", projects);
//			model.addAttribute("joined", joined);
//			model.addAttribute("thisUser", thisUser);
//			return "Success.jsp";
//		} else {
//			return "redirect:/";
//		}
//	}
	
	@GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") != null) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        model.addAttribute("projects1",projectService.getProjectsNotfor(thisUser));
        model.addAttribute("projects2",projectService.getProjectsfor(thisUser));
        return "Success.jsp";
    }
    	else {
    		return "redirect:/";
    	}
    }
	
	@GetMapping("/projects/new")
	public String index(@ModelAttribute("project") Project project, Model model, HttpSession session) {
		User user=userServ.findUserById((Long) session.getAttribute("user_id"));
		session.setAttribute("thisUser", user);
		return "NewProject.jsp";
	}
	
	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result,HttpSession session, Model model) {
		if (result.hasErrors()) {
			List<Project> projects = projectService.allProjects();
			model.addAttribute("projects", projects);
			return "NewProject.jsp";
		} else {
			User user=userServ.findUserById((Long) session.getAttribute("user_id"));
			session.setAttribute("thisUser", user);
			projectService.createProject(project);
	    	List<User> users=new ArrayList<User>();
	    	users.add(user);
	    	project.setUserjoin(users);
	    	projectService.updateProject(project);
			return "redirect:/home";
		}
	}
	@RequestMapping("/join/{id}")
	public String join(@PathVariable("id") Long id ,HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User thisUser = userServ.findUserById(user_id);
		
		Project pro = projectService.findProject(id);
		pro.getUserjoin().add(thisUser);
		projectService.updateProject(pro);
		return "redirect:/home";
	}
	
	@RequestMapping("/disjoin/{id}")
	public String disjoin(@PathVariable("id") Long id ,HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		User thisUser = userServ.findUserById(user_id);
		
		Project pro = projectService.findProject(id);
		pro.getUserjoin().remove(thisUser);
		projectService.updateProject(pro);
		return "redirect:/home";
	}
	
	@GetMapping("/projects/{id}/delete")
	public String destroy2(@PathVariable("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/home";
	}
	
	@GetMapping("/projects/{id}/edit")
	public String index2( Model model, HttpSession session,@PathVariable("id")Long id ) {
		List<Project> projects = projectService.allProjects();
		Project pro = projectService.findProject(id);
		model.addAttribute("pro", pro);
		model.addAttribute("projects", projects);
		return "EditProject.jsp";
	}
	
	@PutMapping("/projects/{id}/edit")
	public String edit(@Valid @ModelAttribute("pro") Project project, BindingResult result, @PathVariable("id")Long id, Model model) {
		Project projects = projectService.findProject(id);
		List<User> pppp = projects.getUserjoin();
		if (result.hasErrors()) {
			model.addAttribute("projects", projects);
			return "EditProject.jsp";
		} else {
			project.setUserjoin(pppp);
			projectService.createProject(project);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/projects/{id}")
	public String show(@PathVariable(required = false) Long id, @ModelAttribute("project") Project project, Model model,
			HttpSession session) {
		Project thisProject = projectService.findProject(id);
		model.addAttribute("projects", thisProject);
		return "ShowProject.jsp";
	}
	
}