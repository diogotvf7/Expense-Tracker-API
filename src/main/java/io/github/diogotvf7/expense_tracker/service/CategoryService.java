package io.github.diogotvf7.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.diogotvf7.expense_tracker.model.Category;
import io.github.diogotvf7.expense_tracker.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
