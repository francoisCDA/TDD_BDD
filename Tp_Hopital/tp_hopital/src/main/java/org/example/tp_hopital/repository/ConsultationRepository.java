package org.example.tp_hopital.repository;

import exception.NotImplementedMethodeException;
import org.example.tp_hopital.entity.Consultation;

import java.util.List;

public class ConsultationRepository extends Repository<Consultation> {
    @Override
    public Consultation findById(int id) {
        return session.get(Consultation.class, id);
    }

    @Override
    public List<Consultation> findAll() {
        throw new NotImplementedMethodeException();
    }
}
