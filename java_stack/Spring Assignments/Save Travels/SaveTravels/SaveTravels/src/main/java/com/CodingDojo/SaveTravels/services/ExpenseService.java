package com.CodingDojo.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CodingDojo.SaveTravels.models.Expense;
import com.CodingDojo.SaveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	// adding the expense repository as a dependency

	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	// returns all the expenses

	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}

//	creates an expense

	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	// retrieves an expense

	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	// updateExpense will take in an Expense object and save it to our database
	// our repository will automatically update an existing Expense object if their
	// IDs match

	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	// to delete an expense, we simply pass in the expense ID and if our repository
	// finds it, the expense will be deleted

	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}
	}
}
