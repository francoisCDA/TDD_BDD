package org.example.tp_hopital.service;

import exception.RepositoryException;
import org.example.tp_hopital.entity.Patient;
import org.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PatientService {

    Repository<Patient> patientRepository;

    SessionFactory sessionFactory;

    public PatientService(SessionFactory sessionFactory, Repository<Patient> patientRepository) {
        this.sessionFactory = sessionFactory;
        this.patientRepository = patientRepository;
    }

    public boolean createPatient(String name, String phone) throws RepositoryException {
        boolean ret = false;
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        Patient patient = Patient.builder().name(name).phone(phone).build();

        session.beginTransaction();

        try {
            patientRepository.create(patient);
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
