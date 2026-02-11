package io.github.diogotvf7.expense_tracker.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.diogotvf7.expense_tracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e FROM Expense e WHERE "
            + "(:category IS NULL OR e.category.name = :category) AND "
            + "(:minAmount IS NULL OR e.amount >= :minAmount) AND "
            + "(:maxAmount IS NULL OR e.amount <= :maxAmount)")
    List<Expense> findWithFilters(@Param("category") String category, @Param("minAmount") BigDecimal minAmount, @Param("maxAmount") BigDecimal maxAmount);
}
