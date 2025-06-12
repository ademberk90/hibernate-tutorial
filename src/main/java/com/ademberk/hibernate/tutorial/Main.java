package com.ademberk.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            // Address kaydı oluşturuyoruz.
            Address address = new Address();
            address.setCity("İzmir");
            address.setStreet("Konak Mah.");

            // Bir tane daha Address kaydı oluşturuyoruz.
            Address address1 = new Address();
            address1.setCity("İstanbul");
            address1.setStreet("Valide-i Atik Mah.");

            // Bir tane daha Address kaydı oluşturuyoruz.
            Address address2 = new Address();
            address2.setCity("Ankara");
            address2.setStreet("Çankaya Mah.");

            // User kaydı oluşturuyoruz.
            User user = new User();
            user.setUsername("Adem Berk");
            user.setEmail("ademberk90@gmail.com");
            user.setAddresses(Arrays.asList(address, address1));

            // Bir tane daha user kaydı oluşturuyoruz.
            User user1 = new User();
            user1.setUsername("Ahmet");
            user1.setEmail("ahmet@gmail.com");
            user1.setAddresses(Arrays.asList(address, address1));

            // Bir tane daha user kaydı oluşturuyoruz.
            User user2 = new User();
            user2.setUsername("Ayşe");
            user2.setEmail("ayse@gmail.com");
            user2.setAddresses(Arrays.asList(address, address1));

            // Adres kayıtlarımızı user ile ilşkilendiriyoruz.
            address.setUsers(Arrays.asList(user, user1));
            address1.setUsers(Arrays.asList(user1, user2));
            address2.setUsers(Arrays.asList(user2));

            session.persist(user);
            session.persist(user1);
            session.persist(user2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback(); // Hatalı işlem geri alınır
        } finally {
            session.close();
        }
    }
}