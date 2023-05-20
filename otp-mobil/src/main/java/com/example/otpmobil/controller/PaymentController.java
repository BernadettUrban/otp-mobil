package com.example.otpmobil.controller;

import com.example.otpmobil.dto.PaymentDTO;
import com.example.otpmobil.models.Payment;
import com.example.otpmobil.services.PaymentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PaymentController {
    private final PaymentServiceImpl paymentService;
    private final String path = "src\\main\\resources\\static\\csv_input\\payments.csv";

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/savePayments")
    public String savePaymentsToDatabase() throws IOException {
        List<PaymentDTO> beansFromCsv = paymentService.readBeansFromCsv(path);
        List<PaymentDTO> validatedBeans = paymentService.validatePaymentBeansFromCSV(beansFromCsv);
        List<Payment> payments = paymentService.convertPaymentDTOtoPayment(validatedBeans);
        paymentService.savePaymentToDB(payments);

        return "Payments saved to db";
    }
}
