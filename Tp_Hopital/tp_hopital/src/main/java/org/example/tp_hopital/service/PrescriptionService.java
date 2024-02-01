package org.example.tp_hopital.service;

import exception.RepositoryException;
import org.example.tp_hopital.entity.Consultation;
import org.example.tp_hopital.entity.FicheDeSoin;
import org.example.tp_hopital.entity.Prescription;
import org.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PrescriptionService {

    Repository<Prescription> prescriptionRepository;

    SessionFactory sessionFactory;

    public PrescriptionService(SessionFactory sessionFactory, Repository<Prescription> prescriptionRepository){
        this.sessionFactory = sessionFactory;
        this.prescriptionRepository = prescriptionRepository;
    }

    public boolean createPrescription(String medicament, String posologie, Consultation consultation) throws RepositoryException {
        boolean ret = false;
        Session session = sessionFactory.openSession();
        prescriptionRepository.setSession(session);

        Prescription prescription = Prescription.builder().medicament(medicament).posologie(posologie).consultation(consultation).build();

        session.beginTransaction();

        try {
            prescriptionRepository.create(prescription);
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
