package io.github.diogotvf7.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.diogotvf7.expense_tracker.model.Expense;
import io.github.diogotvf7.expense_tracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpense(Long id) {
        return expenseRepository.findById(id);
    }

    public boolean deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Expense createExpense(Expense expense) {
        expense.setTimestamp(java.time.LocalDateTime.now());
        return expenseRepository.save(expense);
    }

}
