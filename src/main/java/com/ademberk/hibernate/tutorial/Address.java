package com.ademberk.hibernate.tutorial;

import jakarta.persistence.*;

@Embeddable
public class Address {

    // "username" sütunu: boş bırakılamaz.
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;


    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
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


    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
