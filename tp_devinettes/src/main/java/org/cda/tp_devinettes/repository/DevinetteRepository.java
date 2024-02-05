package org.cda.tp_devinettes.repository;

import org.cda.tp_devinettes.entity.Devinette;

import java.util.List;

public class DevinetteRepository extends Repository<Devinette> {
    @Override
    public Devinette findById(int id) {
        return session.get(Devinette.class,id);
    }

    @Override
    public List<Devinette> findAll() {
        List<Devinette> ret = null;

        try {
            ret = session.createQuery("from devinette").list();
        } catch (Exception ignored) {

        } finally {
            session.close();
        }

        return ret;
    }


}
