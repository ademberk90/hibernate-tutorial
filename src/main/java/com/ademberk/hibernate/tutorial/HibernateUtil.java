package com.ademberk.hibernate.tutorial;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil sınıfı, Hibernate'in SessionFactory nesnesini uygulama genelinde
 * merkezi olarak yönetmek için kullanılan yardımcı (utility) bir sınıftır.
 *
 * Singleton pattern kullanılarak yalnızca bir kez oluşturulur ve tüm uygulama boyunca kullanılır.
 */
public class HibernateUtil {

    // SessionFactory nesnesi, uygulama boyunca bir kez oluşturulacak (singleton)
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * SessionFactory'yi oluşturan özel metot.
     * Hibernate konfigürasyon dosyasını (hibernate.cfg.xml) okuyarak yapılandırmayı başlatır.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Hibernate konfigürasyonunu oku ve SessionFactory oluştur
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Hata durumunda istisna fırlat (örneğin config dosyası eksikse)
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * SessionFactory nesnesini dışarıya sunar.
     * Diğer sınıflar bu metod üzerinden Hibernate oturumu (Session) başlatabilir.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
