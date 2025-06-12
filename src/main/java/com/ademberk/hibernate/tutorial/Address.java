package com.ademberk.hibernate.tutorial;

import jakarta.persistence.*;

import java.util.List;

@Entity // Bu sınıfın bir JPA entity (varlık) olduğunu belirtir.
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY: Genellikle veritabanının kendi otomatik artan özelliğini kullanır (örneğin AUTO_INCREMENT).
    private Long id;

    // "username" sütunu: boş bırakılamaz.
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;



    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> user) {
        this.users = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
