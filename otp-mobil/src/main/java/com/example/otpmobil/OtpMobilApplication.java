package com.example.otpmobil;

import com.example.otpmobil.services.CustomerServiceImpl;
import com.example.otpmobil.services.LoggerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtpMobilApplication implements CommandLineRunner {
    //private final static Logger logger = Logger.getLogger(OtpMobilApplication.class);
    private final LoggerService loggerService;

    public OtpMobilApplication(LoggerService loggerService, CustomerServiceImpl customerService) {
        this.loggerService = loggerService;

    }

    public static void main(String[] args) {
        SpringApplication.run(OtpMobilApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.loggerService.error("Hello SpringBoot!");
    }
}
