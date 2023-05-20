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
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Webshop webshop;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Payment> paymentsByCustomer;
    private String name;

    private String address;

    public Customer(String customerId, Webshop webshop, List<Payment> paymentsByCustomer, String name, String address) {
        this.customerId = customerId;
        this.webshop = webshop;
        this.paymentsByCustomer = paymentsByCustomer;
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

    public Webshop getWebshop() {
        return webshop;
    }

    public void setWebshop(Webshop webshop) {
        this.webshop = webshop;
    }

    public List<Payment> getPaymentsByCustomer() {
        return paymentsByCustomer;
    }

    public void setPaymentsByCustomer(List<Payment> paymentsByCustomer) {
        this.paymentsByCustomer = paymentsByCustomer;
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
