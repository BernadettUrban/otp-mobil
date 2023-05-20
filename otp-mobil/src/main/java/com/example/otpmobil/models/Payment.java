package com.example.otpmobil.models;


import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Webshop webshop;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Customer customer;

    private String paymentMode;

    private Long amount;

    private String bankAccountNo;

    private String cardNo;

    public Payment(Webshop webshop, Customer customer, String paymentMode, Long amount, String bankAccountNo, String cardNo) {
        this.webshop = webshop;
        this.customer = customer;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.bankAccountNo = bankAccountNo;
        this.cardNo = cardNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Webshop getWebshop() {
        return webshop;
    }

    public void setWebshop(Webshop webshop) {
        this.webshop = webshop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
