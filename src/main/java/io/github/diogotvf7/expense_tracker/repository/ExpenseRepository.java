package io.github.diogotvf7.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.diogotvf7.expense_tracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
