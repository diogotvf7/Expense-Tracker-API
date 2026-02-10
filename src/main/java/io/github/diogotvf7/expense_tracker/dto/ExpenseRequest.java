package io.github.diogotvf7.expense_tracker.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ExpenseRequest(
        @NotBlank
        String description,
        @Positive
        BigDecimal amount,
        @NotNull
        Long categoryId
        ) {

}
