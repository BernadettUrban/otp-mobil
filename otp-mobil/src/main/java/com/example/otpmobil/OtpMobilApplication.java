package com.example.otpmobil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtpMobilApplication {
    static {
        System.setProperty("logback.configurationFile", "otp-mobil\\config\\logback\\logback.xml");
    }

    public static void main(String[] args) {
        SpringApplication.run(OtpMobilApplication.class, args);
    }
}
