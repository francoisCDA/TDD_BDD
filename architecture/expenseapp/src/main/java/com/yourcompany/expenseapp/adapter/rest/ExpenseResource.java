package com.yourcompany.expenseapp.adapter.rest;

import com.yourcompany.expenseapp.adapter.persistence.ExpenseRepositoryImpl;
import com.yourcompany.expenseapp.domain.exception.InvalidExpenseDescriptionException;
import com.yourcompany.expenseapp.domain.model.Expense;
import com.yourcompany.expenseapp.domain.repository.ExpenseRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("expense")
public class ExpenseResource {

    private final ExpenseRepository expenseRepository;

    public ExpenseResource() {
        this.expenseRepository = new ExpenseRepository(new ExpenseRepositoryImpl());
    }

    @GET
   // @Produces(MediaType.APPLICATION_JSON)
    public List<String> get(){
        List<Expense> listDepenses = expenseRepository.getAll();

        List<String> retLazyDTO = new ArrayList<>();

        if (listDepenses != null && !listDepenses.isEmpty() ) {
            for (Expense depense:listDepenses) {
                retLazyDTO.add(depense.toString());
            }
        } else {
            retLazyDTO.add("aucune dépense enregistrée");
        }

        return retLazyDTO;

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(String title, Double amount) {
        try {
            expenseRepository.create(title,amount);
            return Response.ok().build();
        } catch (InvalidExpenseDescriptionException e) {
            return Response.status(500, e.getMessage()).build();
        }

    }


}
