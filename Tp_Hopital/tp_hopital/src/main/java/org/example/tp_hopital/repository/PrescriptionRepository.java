package org.example.tp_hopital.repository;

import org.example.tp_hopital.entity.Prescription;

import java.util.List;

public class PrescriptionRepository extends Repository<Prescription> {
    @Override
    public Prescription findById(int id) {
        return session.get(Prescription.class, id);
    }

    @Override
    public List<Prescription> findAll() {
        return session.createQuery("from Prescription").list();
    }



}
