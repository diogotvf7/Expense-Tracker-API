package io.github.diogotvf7.expense_tracker.service;

import java.util.List;

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
}
