package com.example.otpmobil.models;


import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String webshopId;
    private String customerId;

    private String webshopCustomerId;
    private String paymentMode;

    private Long amount;

    private String bankAccountNo;

    private String cardNo;

    public Payment(String webshopId, String customerId, String webshopCustomerId, String paymentMode, Long amount, String bankAccountNo, String cardNo) {
        this.webshopId = webshopId;
        this.customerId = customerId;
        this.webshopCustomerId = webshopCustomerId;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.bankAccountNo = bankAccountNo;
        this.cardNo = cardNo;
    }

    public Payment() {

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWebshopCustomerId() {
        return webshopCustomerId;
    }

    public void setWebshopCustomerId(String webshopCustomerId) {
        this.webshopCustomerId = webshopCustomerId;
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
