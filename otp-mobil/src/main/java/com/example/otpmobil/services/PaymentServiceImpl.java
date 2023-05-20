package com.example.otpmobil.services;

import com.example.otpmobil.dto.CustomerDTO;
import com.example.otpmobil.dto.PaymentDTO;
import com.example.otpmobil.mappers.CustomerMapper;
import com.example.otpmobil.mappers.PaymentMapper;
import com.example.otpmobil.models.Customer;
import com.example.otpmobil.models.Payment;
import com.example.otpmobil.repositories.PaymentRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDTO> readBeansFromCsv(String path) throws IOException {
        Path csvFilePath = Paths.get(path);
        CsvToBean<PaymentDTO> paymentBeans = new CsvToBeanBuilder(Files.newBufferedReader(csvFilePath))
                                .withType(PaymentDTO.class)
                                .withSeparator(';')
                                .withThrowExceptions(false)
                                .build();
       return  paymentBeans.parse();

    }
    public List<PaymentDTO> validatePaymentBeansFromCSV(List<PaymentDTO> beansFromCsv){
        List<PaymentDTO> validatedBeans = new ArrayList<>();
        String pattern = "((18|19|20)[0-9]{2}[\\-.](0[13578]|1[02])[\\-.](0[1-9]|[12][0-9]|3[01]))|(18|19|20)[0-9]{2}[\\-.](0[469]|11)[\\-.](0[1-9]|[12][0-9]|30)|(18|19|20)[0-9]{2}[\\-.](02)[\\-.](0[1-9]|1[0-9]|2[0-8])|(((18|19|20)(04|08|[2468][048]|[13579][26]))|2000)[\\-.](02)[\\-.]29";
        for (PaymentDTO paymentDTO:beansFromCsv) {
            if (paymentDTO.getBankAccountNo().isBlank() && paymentDTO.getPaymentMode().equals("transfer")) {
                 System.out.println("hiányzó bankszámlaszám");
                 //logger.error("hiányzó bankszámlaszám");
              } else if (paymentDTO.getCardNo().isBlank() && paymentDTO.getPaymentMode().equals("card")) {
                  System.out.println("hiányzó bankkártyaszám");
              } else if (!(paymentDTO.getDate().matches(pattern))) {
                  System.out.println("nem megfelelő dátum formátum");
              } else {
                validatedBeans.add(paymentDTO);
             }
        }
        return validatedBeans;
    }

    public List<Payment> convertPaymentDTOtoPayment(List<PaymentDTO> paymentDTOs){
        List<Payment> payments = new ArrayList<>();
        for (PaymentDTO dto:paymentDTOs) {
            Payment payment = PaymentMapper.INSTANCE.paymentDtoToPayment(dto);
            payments.add(payment);
        }
        return payments;
    }

    public void savePaymentToDB(List<Payment> payments){
        for (Payment payment:payments) {
            this.paymentRepository.save(payment);
        }
    }
}
