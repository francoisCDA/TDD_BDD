package org.cda.tp_devinettes.service;

import org.cda.tp_devinettes.entity.Devinette;
import org.cda.tp_devinettes.entity.Reponse;
import org.cda.tp_devinettes.exception.DataBaseException;
import org.cda.tp_devinettes.exception.IncompleteDataException;
import org.cda.tp_devinettes.repository.DevinetteRepository;

import org.cda.tp_devinettes.repository.ReponseRepository;
import org.cda.tp_devinettes.repository.Repository;
import org.cda.tp_devinettes.util.HibernateSession;
import org.hibernate.SessionFactory;

import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class DevinetteService {

    private ReponseRepository reponseRepository;

    private DevinetteRepository devinetteRepository;

    private SessionFactory sessionFactory;

    private static DevinetteService instance;

    public DevinetteService(SessionFactory sessionFactory, ReponseRepository reponseRepository, DevinetteRepository devinetteRepository  ) {
        this.sessionFactory = sessionFactory;
        this.reponseRepository = reponseRepository;
        this.devinetteRepository = devinetteRepository;
    }

    public boolean newRiddle(Devinette riddle) throws DataBaseException, IncompleteDataException {

        if (riddle.getRiddle() == null) throw new IncompleteDataException(" riddle is null ");
        if (riddle.getAnswer() == null) throw new IncompleteDataException("answer is null");
        if (riddle.getRiddle().trim().length() < 15 ) throw new IncompleteDataException("riddle is to short");

        return devinetteRepository.create(riddle);
    }

    public String newRiddle(String riddle, String answer) {

        Devinette newRiddle = Devinette.builder().riddle(riddle).answer(answer).build();
        devinetteRepository.setSession(sessionFactory.openSession());
        try {
            if (devinetteRepository.create(newRiddle)) {
                return null;
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return "une erreur est survenue";
    }

    public boolean saveUserAnswer(Reponse userAnswer) {
        reponseRepository.setSession(sessionFactory.openSession());
        boolean ret = false;
        try {
            reponseRepository.create(userAnswer);
            ret = true;
        } catch (DataBaseException e) {

        }
        return ret;
    }


    public boolean userTry(Reponse userAnswer) {
        return userAnswer.getUserAnswer().equalsIgnoreCase(userAnswer.getDevinette().getAnswer());
    }

    public List<Devinette> getAllRiddles() {
        devinetteRepository.setSession(sessionFactory.openSession());
        return devinetteRepository.findAll();
    }

    public List<Reponse> getAnswersByRiddleId(int riddleId){
        devinetteRepository.setSession(sessionFactory.openSession());
        List<Reponse> ret = reponseRepository.getAnswersByRiddleId(riddleId);

        if (ret == null) {
            return new ArrayList<Reponse>();
        }else {
            return ret;
        }
    }

    public Devinette getRiddleById(int idRiddle) {
        devinetteRepository.setSession(sessionFactory.openSession());

        return devinetteRepository.findById(idRiddle);

    }




    public static DevinetteService get() {
        if (instance == null) {
            instance = new DevinetteService(HibernateSession.getHibernateSession(),new ReponseRepository(),new DevinetteRepository());
        }
        return instance;
    }



}
