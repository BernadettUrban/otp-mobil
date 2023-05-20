package com.example.otpmobil.controller;

import com.example.otpmobil.dto.CustomerDTO;
import com.example.otpmobil.models.Customer;
import com.example.otpmobil.services.CustomerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerServiceImpl customerService;
    private final String fileName = "src\\main\\resources\\static\\csv_input\\customer.csv";

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/saveCustomers")
    public String saveCustomersToDatabase() throws FileNotFoundException {
        //customerService.saveCustomer();
        List<CustomerDTO> customerDTOList = customerService.readBeansFromCsv(fileName);
        List<Customer> customers = customerService.convertCustomerDTOtoCustomer(customerDTOList);
        customerService.saveCustomerToDB(customers);
        return "Customers saved to db";
    }
}
