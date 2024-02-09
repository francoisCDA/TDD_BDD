package com.yourcompany.expenseapp.application.ports.output;

import com.yourcompany.expenseapp.domain.model.Expense;

import java.util.List;

public interface ExpensePersistencePort {

    List<Expense> getAll();

    void save(Expense depense);
}
