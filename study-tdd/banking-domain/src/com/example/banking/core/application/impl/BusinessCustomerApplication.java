package com.example.banking.core.application.impl;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.domain.Iban;
import com.example.banking.core.domain.Money;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.core.repository.CustomerRepository;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class BusinessCustomerApplication implements CustomerApplication {

    private CustomerRepository customerRepository;

    public BusinessCustomerApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean transferMoney(TcKimlikNo identity, Iban fromIban, Iban toIban, Money money) {
        var customer = customerRepository.findCustomerByIdentity(identity);
        if (!customer.isPresent()) throw new IllegalArgumentException("Cannot find customer");
        var realCustomer = customer.get();
        var from = realCustomer.findAccountByIban(fromIban);
        if (!from.isPresent()) throw new IllegalArgumentException("No such account exists");
        var to = realCustomer.findAccountByIban(toIban);
        if (!to.isPresent()) throw new IllegalArgumentException("No such account exists");
        from.get().withdraw(money);
        to.get().deposit(money);
        customerRepository.save(realCustomer);
        return true;
    }
}
