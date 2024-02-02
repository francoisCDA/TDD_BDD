package org.cda.tp_devinettes.service;

import org.cda.tp_devinettes.entity.Devinette;
import org.cda.tp_devinettes.entity.Reponse;
import org.cda.tp_devinettes.exception.DataBaseException;
import org.cda.tp_devinettes.exception.IncompleteDataException;
import org.cda.tp_devinettes.repository.DevinetteRepository;

import org.cda.tp_devinettes.repository.Repository;
import org.hibernate.SessionFactory;

public class DevinetteService {

    private Repository<Reponse> reponseRepository;

    private Repository<Devinette> devinetteRepository;

    private SessionFactory sessionFactory;


    public DevinetteService(SessionFactory sessionFactory, Repository<Reponse> reponseRepository, Repository<Devinette> devinetteRepository  ) {
        this.sessionFactory = sessionFactory;
        this.reponseRepository = reponseRepository;
        this.devinetteRepository = devinetteRepository;
    }



    public void newRiddle(Devinette riddle) throws DataBaseException, IncompleteDataException {

        if (riddle.getRiddle() == null) throw new IncompleteDataException("riddle is null");
        if (riddle.getRiddle().trim().length() < 15 ) throw new IncompleteDataException("riddle is to short");


        devinetteRepository.create(riddle);

    }


}
