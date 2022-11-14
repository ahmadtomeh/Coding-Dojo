package com.CodingDojo.LoginAndRegistration.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
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

import com.CodingDojo.LoginAndRegistration.models.Book;
import com.CodingDojo.LoginAndRegistration.models.LoginUser;
import com.CodingDojo.LoginAndRegistration.models.User;
import com.CodingDojo.LoginAndRegistration.repositories.UserRepository;
import com.CodingDojo.LoginAndRegistration.services.BookService;
import com.CodingDojo.LoginAndRegistration.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserRepository userRepo;

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
			
			List<Book> books = bookService.allBooks();
			model.addAttribute("books", books);
			model.addAttribute("thisUser", thisUser);
			return "Success.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/new")
	public String index(@ModelAttribute("book") Book book, Model model,HttpSession session) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "NewBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Book> books = bookService.allBooks();
			model.addAttribute("books", books);
			return "NewBook.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable(required = false) Long id,@ModelAttribute("book") Book book, Model model,HttpSession session) {
		Book thisBook = bookService.findBook(id);
		model.addAttribute("books", thisBook);
		return "ShowBook.jsp";
	}
	@DeleteMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
        return "redirect:/home";
    }
	
	@GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
		Book books = bookService.findBook(id);
        model.addAttribute("books", books);
        Long user_id = (Long) session.getAttribute("user_id");
        if (books.getUser().getId() == user_id) {
        	return "EditBook.jsp";
        }
        else {
        	return "redirect:/home";
        }
    }
    
    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("books") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "EditBook.jsp";
        } else {
        	bookService.updateBook(book);
            return "redirect:/home";
        }
    }

}