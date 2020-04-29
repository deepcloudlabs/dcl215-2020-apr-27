package com.example.banking.core.application;

import com.example.banking.core.application.impl.BusinessCustomerApplication;
import com.example.banking.core.domain.*;
import com.example.banking.core.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("Customer application")
@ExtendWith(MockitoExtension.class)
public class CustomerApplicationTest {
    @Mock
    CustomerRepository customerRepository ;

    @DisplayName("is created")
    @Test
    void createCustomerApplication(){
        CustomerApplication customerApplication = new BusinessCustomerApplication(null);
        assertNotNull(customerApplication);
    }

    @DisplayName("transfers money between customer's accounts")
    @Test
    void customerTransferMoneyBetweenAccountsShouldSuccess(/*@Mock CustomerRepository customerRepository*/){
        // Test Doubles
        // Dummy Object
        // Fake Object --> InMemory implementation -> HashMap
        // Stub -> Hard Coded values
        // ** Mocking -> Mock library -> Train Mock Object -> Collabration Method
        // Spy ~ Mocking -> Mock & Spy Library (Mockito -> Spring Boot Test)
        // Setup MOCKING
        var jack = new Customer(TcKimlikNo.of("93732057916"), "Jack Bauer");
        var account1 = new Account(Iban.of("TR750006254515519259778812"),
                Money.of(10_000, MoneyCurrency.TL));
        var account2 = new Account(Iban.of("TR280006283276796827672817"),
                Money.of(5_000, MoneyCurrency.TL));
        jack.addAccount(account1);
        jack.addAccount(account2);
        Optional<Customer> customer = Optional.of(jack);
        // Reflection API -> Dynamic Proxy -> Interface
        // Instrumentation API -> CG Library
        Mockito.when(customerRepository.findCustomerByIdentity(TcKimlikNo.of("93732057916")))
                  .thenReturn(customer);
        Mockito.when(customerRepository.save(jack)).thenReturn(true);
        System.err.println(customerRepository.getClass()); // sun.com.Proxy$, $CGLib...

        CustomerApplication customerApplication = new BusinessCustomerApplication(customerRepository);
        // Exercise Method
        var another = customerRepository.findCustomerByIdentity(TcKimlikNo.of("77172318882"));
        System.out.println(another);
        boolean success = customerApplication.transferMoney(TcKimlikNo.of("93732057916"),
                Iban.of("TR750006254515519259778812"),Iban.of("TR280006283276796827672817"), Money.of(1_000., MoneyCurrency.TL));
        // Verification
        assertAll(
                () -> assertTrue(success),
                () -> assertEquals(Money.of(9_000,MoneyCurrency.TL),account1.getBalance()),
                () -> assertEquals(Money.of(6_000,MoneyCurrency.TL),account2.getBalance())
        );
    }
}
