package com.example.banking.core.application;

import com.example.banking.core.application.impl.BusinessCustomerApplication;
import com.example.banking.core.domain.Iban;
import com.example.banking.core.domain.Money;
import com.example.banking.core.domain.MoneyCurrency;
import com.example.banking.core.domain.TcKimlikNo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("Customer application")
public class CustomerApplicationTest {

    @DisplayName("is created")
    @Test
    void createCustomerApplication() {
        CustomerApplication customerApplication = new BusinessCustomerApplication();
        assertNotNull(customerApplication);
    }

    @DisplayName("transfers money between customer's accounts")
    @Test
    void customerTransferMoneyBetweenAccountsShouldSuccess() {
        CustomerApplication customerApplication = new BusinessCustomerApplication();
        boolean success = customerApplication.transferMoney(TcKimlikNo.of("1"),
                Iban.of("TR1"), Iban.of("TR2"), Money.of(1_000., MoneyCurrency.TL));
        assertTrue(success);
    }
}
