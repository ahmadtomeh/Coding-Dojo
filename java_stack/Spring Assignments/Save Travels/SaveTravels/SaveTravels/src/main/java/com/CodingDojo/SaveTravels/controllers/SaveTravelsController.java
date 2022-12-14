package com.CodingDojo.SaveTravels.controllers;

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

import com.CodingDojo.SaveTravels.models.Expense;
import com.CodingDojo.SaveTravels.services.ExpenseService;

@Controller
public class SaveTravelsController {

	@Autowired
	ExpenseService expenseService;

	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}

	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
		Expense expenses = expenseService.findExpense(id);
        model.addAttribute("expenses", expenses);
        return "edit.jsp";
    }
    
    @PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expenses") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	expenseService.deleteExpense(id);
        return "redirect:/	expenses";
    }
    
    @GetMapping("/expenses/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Expense expenses = expenseService.findExpense(id);
        model.addAttribute("expenses", expenses);
        return "show.jsp";
    }
	
}

