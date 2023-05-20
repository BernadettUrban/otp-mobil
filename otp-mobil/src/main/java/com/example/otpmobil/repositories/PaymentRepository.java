package com.example.otpmobil.repositories;

import com.example.otpmobil.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
