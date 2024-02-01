package org.example.tp_hopital.repository;

import org.example.tp_hopital.entity.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository() {

    }

    @Override
    public Patient findById(int id) {
        return session.get(Patient.class,id);
    }

    @Override
    public List<Patient> findAll() {
        return session.createQuery("from Patient ").list();
    }
}
