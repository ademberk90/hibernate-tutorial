package com.ademberk.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            //Transient nesneler üzerinde persist kullanabiliriz.
            User user = new User("Adem Berk", "ademberk903@gmail.com");
            session.persist(user);

            // ------ READ ------

            // proxy döndürmez, objenin alanlarına erişim isteği atmasak da veritabanına gerekli sorguyu atacaktır.
            User userR = session.byId(User.class).load(1);

            // lazy loading, proxy döndürür yani objenin alanlarına erişim isteği atana kadar select sorgusunu atmayacak.
            // Console'a çıktı almak istediğimizde sorguyu atacaktır.
            //User userR = session.getReference(User.class, 1);

            System.out.println(userR.toString());

            // ------ UPDATE ------
            // Update işlemleri için merge kullanabiliriz.
            userR.setEmail("ademberk901@gmail.com");
            session.merge(user);
            System.out.println(userR.toString());

            // ------ DELETE ------
            session.remove(userR);

            tx.commit();
        } catch (Exception e) {
            tx.rollback(); // Hatalı işlem geri alınır
        } finally {
            session.close();
        }
    }
}