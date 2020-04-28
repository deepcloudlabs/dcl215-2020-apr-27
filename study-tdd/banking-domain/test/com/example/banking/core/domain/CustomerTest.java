package com.example.banking.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("A customer")
public class CustomerTest {

    @Test
    void createCustomer() {
        Customer customer = new Customer(TcKimlikNo.of("62238482522"), "Jack Bauer");
        assertAll(
                () -> assertNotNull(customer),
                () -> assertEquals(TcKimlikNo.of("62238482522"), customer.getIdentity()),
                () -> assertEquals("Jack Bauer", customer.getFullname()),
                () -> assertEquals(Collections.emptyList(), customer.getAccounts())
        );
    }

    @Test
    void addOneAccountToCustomerShouldSuccess() {
        var customer = new Customer(TcKimlikNo.of("62238482522"), "Jack Bauer");
        var account = new Account(Iban.of("TR080006287593984192987224"), Money.of(1_000, MoneyCurrency.TL));

        customer.addAccount(account);
        assertAll(
                () -> assertNotNull(account),
                () -> assertEquals(1, customer.getAccounts().size())
        );
    }

    @Test
    void findExistingAccountByIbanShouldSuccess() {
        var customer = new Customer(TcKimlikNo.of("62238482522"), "Jack Bauer");
        var account = new Account(Iban.of("TR410006264615574568469172"), Money.of(1_000, MoneyCurrency.TL));
        customer.addAccount(account);
        var found = customer.findAccountByIban(Iban.of("TR410006264615574568469172"));
        assertAll(
                () -> assertTrue(found.isPresent()),
                () -> assertEquals(1, customer.getAccounts().size())
        );
    }

    @Test
    void removeExistingAccountByIbanShouldSuccess() {
        var customer = new Customer(TcKimlikNo.of("62238482522"), "Jack Bauer");
        var account = new Account(Iban.of("TR150006267881381946866848"), Money.of(1_000, MoneyCurrency.TL));
        customer.addAccount(account);
        var found = customer.removeAccountByIban(Iban.of("TR150006267881381946866848"));
        assertAll(
                () -> assertTrue(found.isPresent()),
                () -> assertEquals(0, customer.getAccounts().size())
        );
    }

    @Test
    void getTotalMoneyShouldSuccess() {
        var customer = new Customer(TcKimlikNo.of("62238482522"), "Jack Bauer");
        var accounts = List.of(
                new Account(Iban.of("TR870006295954226942823728"), Money.of(1_000, MoneyCurrency.TL)),
                new Account(Iban.of("TR510006245116166426999637"), Money.of(2_000, MoneyCurrency.USD)),
                new Account(Iban.of("TR450006253437217923254359"), Money.of(3_000, MoneyCurrency.EUR)),
                new Account(Iban.of("TR560006211164237111125754"), Money.of(4_000, MoneyCurrency.TL)),
                new Account(Iban.of("TR600006261935713282819711"), Money.of(5_000, MoneyCurrency.USD)),
                new Account(Iban.of("TR900006272964692652658376"), Money.of(6_000, MoneyCurrency.EUR))
        );
        accounts.forEach(acc -> customer.addAccount(acc));
        Map<MoneyCurrency, Optional<Money>> moneyMap = customer.getTotalMoney();
        assertAll(
                () -> assertEquals(Money.of(5_000, MoneyCurrency.TL), moneyMap.get(MoneyCurrency.TL).get()),
                () -> assertEquals(Money.of(7_000, MoneyCurrency.USD), moneyMap.get(MoneyCurrency.USD).get()),
                () -> assertEquals(Money.of(9_000, MoneyCurrency.EUR), moneyMap.get(MoneyCurrency.EUR).get())
        );
    }
}
