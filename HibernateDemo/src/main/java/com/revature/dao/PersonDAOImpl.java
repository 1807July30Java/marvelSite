package com.revature.dao;

import com.revature.beans.Person;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public List<Person> getPeople() {
        List<Person> pl = null;
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        try {
            pl = (List<Person>) s.createQuery("from Person").list();

            tx.commit();
            s.close();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        sf.close();
        return pl;
    }

    @Override
    public Person getPerson(int personID) {
        Person p = null;
        Session s = sf.openSession();
        try {
            p = (Person) s.get(Person.class, personID);

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sf.close();
        return p;
    }

    @Override
    public int addPerson(Person p) {
        int pk = 0;
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        try {
            pk = (int) s.save(p);
            tx.commit();
            s.close();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        sf.close();
        return pk;
    }

    @Override
    public void updatePerson(Person p) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        try {
            s.saveOrUpdate(p);
            tx.commit();
            s.close();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        sf.close();
    }

    @Override
    public void deletePerson(Person p) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        try {
            s.delete(p);
            tx.commit();
            s.close();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        sf.close();
    }
}
