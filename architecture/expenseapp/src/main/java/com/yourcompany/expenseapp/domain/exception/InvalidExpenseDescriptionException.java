package com.yourcompany.expenseapp.domain.exception;

public class InvalidExpenseDescriptionException extends Exception{

    public InvalidExpenseDescriptionException() {
        super("invalid values");
    }
}
