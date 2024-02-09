package com.yourcompany.expenseapp.adapter.persistence;

import com.yourcompany.expenseapp.application.ports.output.ExpensePersistencePort;
import com.yourcompany.expenseapp.domain.model.Expense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ExpenseRepositoryImpl implements ExpensePersistencePort {

    private final StandardServiceRegistry standardServiceRegistry;
    private final SessionFactory sessionFactory;
    private Session session;

    public ExpenseRepositoryImpl() {
        this.standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();;
        sessionFactory  = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
    }


    @Override
    public List<Expense> getAll() {
        List<Expense> ret = null;

        session = sessionFactory.openSession();

        try {
            ret = session.createQuery("from Expense").list();

        } catch (Exception ignored) {

        } finally {
            session.close();
        }

        return ret;

    }

    @Override
    public void save(Expense depense) {

        session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.persist(depense);
            session.getTransaction().commit();

        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
}
