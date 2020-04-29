package com.example.banking.core.steps;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.application.impl.BusinessCustomerApplication;
import com.example.banking.core.domain.*;
import com.example.banking.core.repository.CustomerRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTestSteps {

    private CustomerRepository customerRepository;
    private Customer customer;
    private CustomerApplication customerApplication;

    public ApplicationTestSteps() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerApplication = new BusinessCustomerApplication(customerRepository);
    }

    @Given("^a customer '(.*)' with identity (.*)$")
    public void aCustomerJack(String fullname,String identity){
        customer = new Customer(TcKimlikNo.of(identity),fullname);
    }

    @Given("^account (.*) with (.*) (.*)$")
    public void withAccount(String iban,double amount,String currency){
        var account = new Account(Iban.of(iban), Money.of(amount,MoneyCurrency.valueOf(currency)));
        customer.addAccount(account);
    }

    @When("^the customer transfers (.*) (.*) from account (.*) to account (.*)$")
    public void theCustomerTransferMoneyBetweenAccounts(double amount,String currency,String fromIban,String toIban){
        TcKimlikNo identity = customer.getIdentity();
        Mockito.when(customerRepository.findCustomerByIdentity(identity))
                .thenReturn(Optional.of(customer));
        customerApplication.transferMoney(identity,Iban.of(fromIban),Iban.of(toIban),
             Money.of(amount,MoneyCurrency.valueOf(currency)));
    }

    @Then("^there is (.*) (.*) in account (.*) and (.*) (.*) in account (.*)")
    public void thenVerifyAccounts(double fromAmount,String fromCurrency,String fromIban,
                                   double toAmount,String toCurrency,String toIban){
        assertAll(
                () -> assertEquals(
                        new Account(Iban.of(fromIban),Money.of(fromAmount,MoneyCurrency.valueOf(fromCurrency))),
                        customer.findAccountByIban(Iban.of(fromIban)).get()),
                () -> assertEquals(
                        new Account(Iban.of(toIban),Money.of(toAmount,MoneyCurrency.valueOf(toCurrency))),
                        customer.findAccountByIban(Iban.of(toIban)).get())
        );
    }

}
