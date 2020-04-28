package com.example.banking.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    void createAccount(){
        // setup
        Account acc = new Account("TR1",1_000.);
        // exercise method + verification
        assertAll(
            () -> assertEquals("TR1",acc.getIban()),
            () -> assertEquals(1_000.,acc.getBalance())
        );
    }
}
