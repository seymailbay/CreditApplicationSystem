package com.seymailbay.creditapplicationsystem;

import com.seymailbay.creditapplicationsystem.dto.creditDto.CreditDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.service.creditService.CreditService;
import com.seymailbay.creditapplicationsystem.service.customerService.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CreditApplicationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditApplicationSystemApplication.class, args);
    }

}
