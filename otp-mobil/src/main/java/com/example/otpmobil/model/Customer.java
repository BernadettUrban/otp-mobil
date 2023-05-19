package com.example.otpmobil.model;

import com.opencsv.bean.CsvBindByPosition;

public class Customer {
    @CsvBindByPosition(position = 0)
    private String webshopId;
    @CsvBindByPosition(position = 1)
    private String customerId;
    @CsvBindByPosition(position = 2)
    private String name;
    @CsvBindByPosition(position = 3)
    private String address;

    public Customer(String webshopId, String customerId, String name, String address) {
        this.webshopId = webshopId;
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public Customer() {
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

        @Override
        public String toString() {
            return "Customer{" +
                    "webshopId='" + webshopId + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
}
