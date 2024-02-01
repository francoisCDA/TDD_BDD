package org.example.tp_hopital.service;

import exception.RepositoryException;
import org.example.tp_hopital.entity.Consultation;
import org.example.tp_hopital.entity.Patient;
import org.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class ConsultationService {

    Repository<Consultation> consultationRepository;

    SessionFactory sessionFactory;

    public ConsultationService(SessionFactory sessionFactory, Repository<Consultation> consultationRepository) {
        this.sessionFactory = sessionFactory;
        this.consultationRepository = consultationRepository;
    }


    public boolean createConsultation(String medecin,Patient patient) throws RepositoryException {
        boolean ret = false;
        Session session = sessionFactory.openSession();
        consultationRepository.setSession(session);

        Consultation consultation = Consultation.builder().medecin(medecin).patient(patient).date(LocalDate.now()).build();

        session.beginTransaction();

        try {
            consultationRepository.create(consultation);
            session.getTransaction().commit();
            ret = true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }

        return ret;

    }
}
