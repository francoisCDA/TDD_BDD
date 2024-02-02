package org.cda.tp_devinettes.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {

    private  StandardServiceRegistry standardServiceRegistry;
    private  SessionFactory sessionFactory;

    private static HibernateSession instance;

    private HibernateSession() {
        standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
    }

    public static SessionFactory getHibernateSession() {
        if (instance == null) {
            instance = new HibernateSession();
        }
        return instance.sessionFactory;
    }




}
