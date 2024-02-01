package org.example.tp_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.example.tp_hopital.entity.Consultation;
import org.example.tp_hopital.repository.ConsultationRepository;
import org.example.tp_hopital.repository.FicheDeSoinRepository;
import org.example.tp_hopital.repository.PatientRepository;
import org.example.tp_hopital.repository.PrescriptionRepository;
import org.example.tp_hopital.service.ConsultationService;
import org.example.tp_hopital.service.FicheDeSoinService;
import org.example.tp_hopital.service.PrescriptionService;
import org.example.tp_hopital.util.HibernateSession;

@WebServlet(name = "consultation", value= "/consultation")
public class ConsultationServlet extends HttpServlet {

    private ConsultationService consultationService;

    private FicheDeSoinService ficheDeSoinService;

    private PrescriptionService prescriptionService;

    @Override
    public void init() throws ServletException {

        consultationService = new ConsultationService(HibernateSession.getSessionFactory(), new ConsultationRepository());
        ficheDeSoinService = new FicheDeSoinService(HibernateSession.getSessionFactory(), new FicheDeSoinRepository());
        prescriptionService = new PrescriptionService(HibernateSession.getSessionFactory(), new PrescriptionRepository());

    }

    



}
