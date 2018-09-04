package com.revature.main;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
//        saveVsPersist();
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
//            updateVsMerge(sf);
//            funWithNamedQuery(sf);
            funWithCascadesAndCaching(sf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sf.close();
    }

    public static void funWithCascadesAndCaching(SessionFactory sf) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Cave c = (Cave) s.get(Cave.class, 7);
        BearType bt = (BearType) s.get(BearType.class, 2);
        Bear b = new Bear("Ferdinand", c, bt, 4000, LocalDate.now());
        System.out.println(s.contains(c));
//        s.evict(c);
//        System.out.println(s.contains(c));

//        s.persist(b);

        Bear b2 = new Bear("Marco2", new Cave("Bronx", 6), bt, 100, LocalDate.now());
        s.persist(b2);
        tx.commit();
        s.close();
    }

    public static void funWithNamedQuery(SessionFactory sf) {
        Session s = sf.openSession();
        Query q = s.getNamedQuery("findBearsByType");
        q.setInteger("typeVar", 2);

        List<Bear> bl = q.list();
        System.out.println(bl.size());
        Iterator<Bear> itr = bl.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        s.close();
    }

    public static void updateVsMerge(SessionFactory sf) {

        Cave c = new Cave("Brooklyn", 3);

        Session s1 = sf.openSession();
        Transaction tx1 = s1.beginTransaction();
        s1.persist(c);
        tx1.commit();
        s1.close();

        Session s2 = sf.openSession();
        Transaction tx2 = s2.beginTransaction();
        try {
            Cave c2 = (Cave) s2.get(Cave.class, c.getId());

            c.setName("Barklyn");

//            s2.update(c);
            s2.merge(c);

            tx2.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx2.rollback();
        }
        s2.close();
    }

    public static void saveVsPersist(SessionFactory sf) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

//        Cave c = new Cave("Indiana", 8);
//        System.out.println(s.save(c));

        BearType bt = new BearType("Polar", "Add greenhouse gasses to atmosphere");
        s.persist(bt);

        tx.commit();
        s.close();
    }

    public static void getVsLoad(SessionFactory sf) {
        Session s = sf.openSession();

        Bear b = (Bear) s.get(Bear.class, 3);
        System.out.println(b);

        Cave c = (Cave) s.get(Cave.class, 1);
        System.out.println(c.getBears());

        s.close();
    }

    public static void insert(SessionFactory sf) {
        Session s = sf.openSession();

//        System.out.println(s.createQuery("FROM Cave").list());
//        System.out.println(s.createQuery("FROM bearType").list());
        Transaction tx = s.beginTransaction();
        Bear b1 = new Bear("Marco", new Cave("Queens", 7), new BearType("Grizzly", "lol"), 400, LocalDate.now());
        s.persist(b1);

        tx.commit();
        s.close();
    }
}
