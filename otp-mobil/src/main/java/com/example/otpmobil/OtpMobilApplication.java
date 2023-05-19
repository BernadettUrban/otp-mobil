package com.example.otpmobil;

import com.example.otpmobil.dto.CustomerDTO;
import com.example.otpmobil.dto.PaymentDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OtpMobilApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(OtpMobilApplication.class, args);

        String fileName = "src\\main\\resources\\static\\csv_input\\customer.csv";

        List<CustomerDTO> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(CustomerDTO.class)
                .withSeparator(';')
                .build()
                .parse();

        beans.forEach(System.out::println);
        String path = "src\\main\\resources\\static\\csv_input\\payments.csv";
        Path csvFilePath = Paths.get(path);

        CsvToBean<PaymentDTO> paymentBeans = new CsvToBeanBuilder(Files.newBufferedReader(csvFilePath))
                .withType(PaymentDTO.class)
                .withSeparator(';')
                .withThrowExceptions(false)
                .build();
        List<PaymentDTO> paymentDTOs = paymentBeans.parse();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        for (PaymentDTO paymentDTO : paymentDTOs) {

            Set<ConstraintViolation<PaymentDTO>> violations = validator.validate(paymentDTO);
            for (ConstraintViolation<PaymentDTO> violation : violations) {
                System.out.println(violation.getMessage());
            }

        }
        System.out.println(paymentDTOs);

    }

}
