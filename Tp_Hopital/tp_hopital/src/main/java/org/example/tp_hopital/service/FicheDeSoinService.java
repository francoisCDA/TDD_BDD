package org.example.tp_hopital.service;

import exception.RepositoryException;
import org.example.tp_hopital.entity.Consultation;
import org.example.tp_hopital.entity.FicheDeSoin;
import org.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FicheDeSoinService {

    Repository<FicheDeSoin> ficheDeSoinRepository;

    SessionFactory sessionFactory;


    public FicheDeSoinService(SessionFactory sessionFactory,Repository<FicheDeSoin> ficheDeSoinRepository){
        this.sessionFactory = sessionFactory;
        this.ficheDeSoinRepository = ficheDeSoinRepository;
    }


    public boolean createFicheDeSoin(String typeSoin, int nbJour, Consultation consultation) throws RepositoryException {
        boolean ret = false;
        Session session = sessionFactory.openSession();
        ficheDeSoinRepository.setSession(session);

        FicheDeSoin ficheDeSoin = FicheDeSoin.builder().typeSoin(typeSoin).nbjour(nbJour).consultation(consultation).build();

        session.beginTransaction();

        try {
            ficheDeSoinRepository.create(ficheDeSoin);
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
