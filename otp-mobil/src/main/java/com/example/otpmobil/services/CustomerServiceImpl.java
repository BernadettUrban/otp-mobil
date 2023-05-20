package com.example.otpmobil.services;

import com.example.otpmobil.dto.CustomerDTO;
import com.example.otpmobil.mappers.CustomerMapper;
import com.example.otpmobil.models.Customer;
import com.example.otpmobil.repositories.CustomerRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> readBeansFromCsv(String fileName) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(fileName))
                .withType(CustomerDTO.class)
                .withSeparator(';')
                .build()
                .parse();
    }

    public List<Customer> convertCustomerDTOtoCustomer(List<CustomerDTO> customerDTOs) {
        List<Customer> customers = new ArrayList<>();
        for (CustomerDTO dto : customerDTOs) {
            Customer customer = CustomerMapper.INSTANCE.customerDtoToCustmer(dto);
            customers.add(customer);
        }
        return customers;
    }

    public void saveCustomerToDB(List<Customer> customers) {
        for (Customer customer : customers) {
            this.customerRepository.save(customer);
        }
    }

}
