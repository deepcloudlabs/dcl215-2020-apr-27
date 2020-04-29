package com.example.banking.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("An account")
public class AccountTest {

    @ParameterizedTest
    @EnumSource(MoneyCurrency.class)
    @DisplayName("is created")
    void createAccount(MoneyCurrency currency) {
        // setup
        Iban iban = Iban.of("TR310006246624644188147598");
        Money money = Money.of(1_000, currency);
        Account acc = new Account(iban, money);
        // exercise method + verification
        assertAll(
                () -> assertEquals(Iban.of("TR310006246624644188147598").getValue(), acc.getIban().getValue()),
                () -> assertEquals(Money.of(1_000, currency), acc.getBalance()),
                () -> assertEquals(1_000, acc.getBalance().getAmount()),
                () -> assertEquals(currency, acc.getBalance().getCurrency())
        );
    }

    @Nested
    @DisplayName("When deposit")
    class Deposit {

        @ParameterizedTest
        @EnumSource(MoneyCurrency.class)
        @DisplayName("positive amount with same currency should be ok")
        void depositWithSuccess(MoneyCurrency currency) {
            // setup
            Iban iban = Iban.of("TR930006284967585417923113");
            Money money = Money.of(1_000, currency);
            Account acc = new Account(iban, money);
            // exercise
            acc.deposit(Money.of(100, currency));
            // verification
            assertEquals(Money.of(1_100, currency), acc.getBalance());
        }

        @Test
        @DisplayName("positive amount with different currency should fail")
        void depositWithDifferentCurrenciesShouldFail() {
            // setup
            Iban iban = Iban.of("TR760006282362637341983919");
            Money money = Money.of(1_000, MoneyCurrency.TL);
            Account acc = new Account(iban, money);
            // exercise + verification
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> acc.deposit(Money.of(100, MoneyCurrency.USD))),
                    () -> assertEquals(1_000, acc.getBalance().getAmount())
            );
        }
    }

    @Nested
    @DisplayName("When withdraw")
    class Withdraw {

        @ParameterizedTest
        @EnumSource(MoneyCurrency.class)
        @DisplayName("all amount with same currency should be ok")
        void withdrawAllMoneyWithSuccess(MoneyCurrency currency) {
            // setup
            Iban iban = Iban.of("TR970006277839614439161488");
            Money money = Money.of(1_000, currency);
            Account acc = new Account(iban, money);
            // exercise
            acc.withdraw(Money.of(1_000, currency));
            // verification
            assertEquals(Money.of(0., currency), acc.getBalance());
        }

        @ParameterizedTest
        @EnumSource(MoneyCurrency.class)
        @DisplayName("over balance with same currency should fail")
        void withdrawOverBalanceShouldFail(MoneyCurrency currency) {
            // setup
            Iban iban = Iban.of("TR280006278397274576185856");
            Money money = Money.of(1_000, currency);
            Account acc = new Account(iban, money);
            // exercise + verification
            assertAll(
                () -> assertThrows(InsufficientBalanceException.class , () -> acc.withdraw(Money.of(1_001, currency))),
                () -> assertEquals(Money.of(1_000., currency), acc.getBalance())
            );
        }
    }

}
