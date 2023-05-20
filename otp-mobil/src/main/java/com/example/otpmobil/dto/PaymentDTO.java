package com.example.otpmobil.dto;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.Pattern;

public class PaymentDTO {
    @CsvBindByPosition(position = 0)
    private String webshopId;
    @CsvBindByPosition(position = 1)
    private String customerId;
    @CsvBindByPosition(position = 2)
    private String paymentMode;

    @CsvBindByPosition(position = 3)
    private Long amount;
    @CsvBindByPosition(position = 4)
    private String bankAccountNo;
    @CsvBindByPosition(position = 5)
    private String cardNo;

    @Pattern(regexp = "((18|19|20)[0-9]{2}[\\-.](0[13578]|1[02])[\\-.](0[1-9]|[12][0-9]|3[01]))|(18|19|20)[0-9]{2}[\\-.](0[469]|11)[\\-.](0[1-9]|[12][0-9]|30)|(18|19|20)[0-9]{2}[\\-.](02)[\\-.](0[1-9]|1[0-9]|2[0-8])|(((18|19|20)(04|08|[2468][048]|[13579][26]))|2000)[\\-.](02)[\\-.]29",
            message = "Valid dátum kell legyen YYYY.HH.NN formátumban")
    @CsvBindByPosition(position = 6)
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "webshopId='" + webshopId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", paymentMode=" + paymentMode +
                ", amount=" + amount +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
