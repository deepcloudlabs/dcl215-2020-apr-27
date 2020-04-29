package com.example.banking.core.repository;

import com.example.banking.core.domain.Customer;
import com.example.banking.core.domain.TcKimlikNo;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findCustomerByIdentity(TcKimlikNo identity);

    boolean save(Customer realCustomer);
}
