package org.cda.tp_devinettes.repository;

import org.cda.tp_devinettes.entity.Reponse;
import org.hibernate.query.Query;

import java.util.List;

public class ReponseRepository extends Repository<Reponse>{
    @Override
    public Reponse findById(int id) {
        return session.get(Reponse.class,id);
    }

    @Override
    public List<Reponse> findAll() {
        return session.createQuery("from reponse").list();
    }

    public List<Reponse> getAnswersByRiddleId(int riddleId) {

        Query<Reponse> query = session.createQuery("from reponse where devinette.id = :riddleId");
        query.setParameter("riddleId",riddleId);

        return query.list();

    }


}
