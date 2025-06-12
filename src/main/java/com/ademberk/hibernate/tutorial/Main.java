package com.ademberk.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            Address address = new Address();
            address.setCity("İzmir");
            address.setStreet("Konak Mah.");

            Address address1 = new Address();
            address1.setCity("İstanbul");
            address1.setStreet("Valide-i Atik Mah.");

            User user = new User();
            user.setUsername("Adem Berk");
            user.setEmail("ademberk90@gmail.com");
            user.setAddresses(Arrays.asList(address, address1));

            address.setUser(user);
            address1.setUser(user);

            session.persist(user);

            tx.commit();
        } catch (Exception e) {
            tx.rollback(); // Hatalı işlem geri alınır
        } finally {
            session.close();
        }
    }
}