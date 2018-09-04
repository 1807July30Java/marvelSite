package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (HibernateUtil.sessionFactory == null) {
            Configuration c = new Configuration().configure("hibernate.cfg.xml");
            c.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
            c.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));
            c.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
            HibernateUtil.sessionFactory = c.buildSessionFactory(sr);
        }
        return HibernateUtil.sessionFactory;
    }

//    public static Session getSession() {
//        return getSessionFactory("hibernate.cfg.xml").openSession();
//    }
}
