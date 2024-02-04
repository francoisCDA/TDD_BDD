package org.cda.tp_devinettes.repository;

import org.cda.tp_devinettes.exception.DataBaseException;
import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    protected Session session;

    public Session getSession() {
        return session;
    }

    public Repository() {

    }

    public void setSession(Session session) {
        this.session = session;
    }


    public boolean create(T elment) throws DataBaseException {
        try {
            this.session.persist(elment);
        } catch (Exception ex) {
            throw new DataBaseException(ex.getMessage());
        } finally {
            session.close();
        }
        return true;
    }

    public void delete(T element) {
        session.remove(element);
    }

    public void update(T element) {
        session.persist(element);
    }

    public abstract T findById(int id);

    public abstract List<T> findAll();


}
