package com.example.otpmobil.services;

import com.example.otpmobil.dto.PaymentDTO;
import com.example.otpmobil.models.Payment;

import java.io.IOException;
import java.util.List;

public interface PaymentService {
    List<PaymentDTO> readBeansFromCsv(String path) throws IOException;

    List<PaymentDTO> validatePaymentBeansFromCSV(List<PaymentDTO> beansFromCsv);

    List<Payment> convertPaymentDTOtoPayment(List<PaymentDTO> paymentDTOs);

    void savePaymentToDB(List<Payment> payments);
}
