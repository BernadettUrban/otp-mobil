package com.example.otpmobil.services;

import com.example.otpmobil.dto.CustomerDTO;
import com.example.otpmobil.models.Customer;

import java.io.FileNotFoundException;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> readBeansFromCsv(String fileName) throws FileNotFoundException;

    List<Customer> convertCustomerDTOtoCustomer(List<CustomerDTO> customerDTOs);

    void saveCustomerToDB(List<Customer> customers);
}
