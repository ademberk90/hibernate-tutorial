package com.ademberk.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("ademberk");
        user.setEmail("ademberk90@gmail.com");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(user);

        tx.commit();
        session.close();

        System.out.println("Kullanıcı başarıyla kaydedildi!!");
    }
}