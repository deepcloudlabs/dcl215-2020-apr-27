package com.example.banking;

import com.example.banking.core.domain.*;
import com.example.banking.repository.CustomerMongoCrudRepository;
import com.example.banking.repository.CustomerMongoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Persistence Adapter Test")
@ExtendWith(SpringExtension.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class CustomerRepositoryTest {
    // CUT -> CustomerMongoRepository -> Spring Bean
    @Autowired
    CustomerMongoRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeEach
    void createTestCustomer(){
        var customer = new Customer(TcKimlikNo.of("84419540678"),
                "Jack Bauer");
        customer.addAccount(new Account(Iban.of("TR280006287292168635822824"), Money.of(1_000_000.,MoneyCurrency.EUR)));
        customer.addAccount(new Account(Iban.of("TR630006264884911854426252"), Money.of(2_000_000.,MoneyCurrency.USD)));
        customer.addAccount(new Account(Iban.of("TR400006212321561776661379"), Money.of(3_000_000.,MoneyCurrency.TL)));
        repository.save(customer);
    }

    @Test
    void findCustomerByIdentityShouldReturnOne(){
        var identity = TcKimlikNo.of("84419540678");
        var customer = repository.findCustomerByIdentity(identity);
        assertAll(
                () -> assertTrue(customer.isPresent()),
                () -> assertEquals(identity, customer.get().getIdentity())
        );
    }

    @AfterEach
    void dropCustomerCollection(){
        // drop collection
        //mongoTemplate.dropCollection(Customer.class);
    }
}
