package io.github.diogotvf7.expense_tracker.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.diogotvf7.expense_tracker.dto.ExpenseRequest;
import io.github.diogotvf7.expense_tracker.model.Category;
import io.github.diogotvf7.expense_tracker.model.Expense;
import io.github.diogotvf7.expense_tracker.repository.CategoryRepository;
import io.github.diogotvf7.expense_tracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public List<Expense> getFilteredExpenses(String category, BigDecimal minAmount, BigDecimal maxAmount) {
        return expenseRepository.findWithFilters(category, minAmount, maxAmount);
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

    public Expense createExpense(ExpenseRequest request) throws RuntimeException {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Expense expense = new Expense();
        expense.setDescription(request.description());
        expense.setAmount(request.amount());
        expense.setCategory(category);
        expense.setTimestamp(java.time.LocalDateTime.now());

        return expenseRepository.save(expense);
    }

}
