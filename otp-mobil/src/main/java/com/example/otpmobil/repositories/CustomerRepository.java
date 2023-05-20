package com.example.otpmobil.repositories;

import com.example.otpmobil.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
