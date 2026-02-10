package io.github.diogotvf7.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.diogotvf7.expense_tracker.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
