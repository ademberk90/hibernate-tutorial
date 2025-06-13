package com.ademberk.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        // İlk önce veritabanına bir user kaydı atalım. Sonra satırı kapatalım.
        //Transaction tx = session.beginTransaction();

        try {
            // İlk önce veritabanına bir user kaydı atalım. Sonra satırı kapatalım.
            /*
            User user = new User();
            user.setUsername("Adem Berk");
            user.setEmail("ademberk90@gmail.com");


            session.persist(user);
            */
            // İlk sorgu: veritabanından gelir
            User user1 = session.byId(User.class).load(1);
            System.out.println(user1);
            session.close();

            // İkinci sorgu: önbellekten gelir
            User user2 =  session2.byId(User.class).load(1);
            System.out.println(user2);
            session2.close();

            System.out.println(user1 == user2);
            // İlk önce veritabanına bir user kaydı atalım. Sonra satırı kapatalım.
            //tx.commit();
        } catch (Exception e) {
            // İlk önce veritabanına bir user kaydı atalım. Sonra satırı kapatalım.
            //tx.rollback(); // Hatalı işlem geri alınır
            session.close();
            session2.close();
        } finally {
            //session.close();
        }
    }
}