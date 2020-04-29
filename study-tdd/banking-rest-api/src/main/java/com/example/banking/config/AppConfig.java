package com.example.banking.config;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.application.impl.BusinessCustomerApplication;
import com.example.banking.core.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerApplication customerApplication(CustomerRepository customerRepository){
        return new BusinessCustomerApplication(customerRepository);
    }
}
