package com.ademberk.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            Address address = new Address();
            address.setCity("İzmir");
            address.setStreet("Konak Mah.");

            User user = new User();
            user.setUsername("Adem Berk");
            user.setEmail("ademberk90@gmail.com");
            // Status setliyoruz
            user.setStatus(User.Status.ACTIVE);
            user.setAddress(address);

            session.persist(user);

            tx.commit();
        } catch (Exception e) {
            tx.rollback(); // Hatalı işlem geri alınır
        } finally {
            session.close();
        }
    }
}