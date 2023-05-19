package com.example.otpmobil;

import com.example.otpmobil.model.Customer;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class OtpMobilApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(OtpMobilApplication.class, args);

        String fileName ="src\\main\\resources\\static\\csv_input\\customer.csv";

        List<Customer> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Customer.class)
                .withSeparator(';')
                .build()
                .parse();

        beans.forEach(System.out::println);


    }

}
