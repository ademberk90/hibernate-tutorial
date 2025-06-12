package com.ademberk.hibernate.tutorial;

import jakarta.persistence.*;

/**
 * User entity class'ı, veritabanındaki "users" tablosu ile eşleştirilir.
 * Bu sınıf, Hibernate ve JPA aracılığıyla ORM işlemleri için kullanılır.
 */
@Entity // Bu sınıfın bir JPA entity (varlık) olduğunu belirtir.
@Table(name = "users") // Entity'nin veritabanındaki "users" tablosuna karşılık geldiğini belirtir.
public class User {

    // Primary key (birincil anahtar) alanı.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY: Genellikle veritabanının kendi otomatik artan özelliğini kullanır (örneğin AUTO_INCREMENT).
    private Long id;

    // "username" sütunu: boş bırakılamaz.
    @Column(name = "username", nullable = false)
    private String username;

    // "email" sütunu: boş bırakılamaz.
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Boş constructor, Hibernate ve JPA tarafından zorunludur.
     * Nesne örneklemesi sırasında framework'ün kullanabilmesi için gereklidir.
     */
    public User() {
    }

    // Parametreli constructor: Kullanıcı adı ve e-posta ile User nesnesi oluşturmak için.
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getter ve Setter metodları: Hibernate bu metodlar aracılığıyla verilere erişir ve değer atar.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
