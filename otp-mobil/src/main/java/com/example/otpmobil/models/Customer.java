package com.example.otpmobil.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String customerId;
    private String webshopId;
    private String webshopCustomerId;
    private String name;

    private String address;

    public Customer(String customerId, String webshopId, String webshopCustomerId, String name, String address) {
        this.customerId = customerId;
        this.webshopId = webshopId;
        this.webshopCustomerId = webshopCustomerId;
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWebshopId() {
        return webshopId;
    }

    public void setWebshopId(String webshopId) {
        this.webshopId = webshopId;
    }

    public String getWebshopCustomerId() {
        return webshopCustomerId;
    }

    public void setWebshopCustomerId(String webshopCustomerId) {
        this.webshopCustomerId = webshopCustomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
