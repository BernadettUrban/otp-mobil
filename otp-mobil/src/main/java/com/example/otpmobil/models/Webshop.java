package com.example.otpmobil.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Webshop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String webshopId;

    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Customer> customers;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Payment> payments;

    public Webshop(String webshopId, List<Customer> customers, List<Payment> payments) {
        this.webshopId = webshopId;
        this.customers = customers;
        this.payments = payments;
    }

    public Webshop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebshopId() {
        return webshopId;
    }

    public void setWebshopId(String webshopId) {
        this.webshopId = webshopId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
