package com.yourcompany.expenseapp.domain.repository;

import com.yourcompany.expenseapp.application.ports.output.ExpensePersistencePort;
import com.yourcompany.expenseapp.domain.exception.InvalidExpenseDescriptionException;
import com.yourcompany.expenseapp.domain.model.Expense;

import java.util.List;

public class ExpenseRepository {

    private final ExpensePersistencePort expensePersistencePort;

    public ExpenseRepository(ExpensePersistencePort expensePersistencePort) {
        this.expensePersistencePort = expensePersistencePort;
    }

    public void create(String title, Double amount) throws InvalidExpenseDescriptionException {

        if (title.isBlank() || title.isEmpty() || amount > 0) throw new InvalidExpenseDescriptionException();

        Expense depense = new Expense(title,amount);

        expensePersistencePort.save(depense);

    }

    public List<Expense> getAll() {
        return expensePersistencePort.getAll();
    }

}
