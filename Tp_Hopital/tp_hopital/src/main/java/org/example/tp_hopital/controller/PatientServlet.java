package org.example.tp_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.example.tp_hopital.repository.PatientRepository;
import org.example.tp_hopital.service.PatientService;
import org.example.tp_hopital.util.HibernateSession;

@WebServlet(name = "patient", value = "/patient")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    @Override
    public void init() throws ServletException {

        patientService = new PatientService(HibernateSession.getSessionFactory(), new PatientRepository());
    }


}
