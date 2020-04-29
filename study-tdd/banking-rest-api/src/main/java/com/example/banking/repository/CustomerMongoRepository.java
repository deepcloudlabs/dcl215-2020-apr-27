package com.example.banking.repository;

import com.example.banking.core.domain.*;
import com.example.banking.core.repository.CustomerRepository;
import com.example.banking.document.AccountDocument;
import com.example.banking.document.CustomerDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// GoF Adapter
@Repository
public class CustomerMongoRepository implements CustomerRepository {
    @Autowired
    CustomerMongoCrudRepository repository; // Spring Data Mongodb

    @Override
    public Optional<Customer> findCustomerByIdentity(TcKimlikNo identity) {
        Optional<CustomerDocument> document = repository.findOneByIdentity(identity.getValue());
        if (!document.isPresent()) Optional.empty();
        Customer customer = new Customer(identity, document.get().getFullname());
        document.get().getAccounts().forEach(accountDocument -> {
            customer.addAccount(new Account(Iban.of(accountDocument.getIban()), Money.of(accountDocument.getBalance(), accountDocument.getCurrency())));
        });
        return Optional.of(customer);
    }

    @Override
    public boolean save(Customer customer) {
        CustomerDocument document = new CustomerDocument();
        document.setIdentity(customer.getIdentity().getValue());
        document.setFullname(customer.getFullname());
        List<AccountDocument> accountDocuments =
                customer.getAccounts().stream().map(acc -> new AccountDocument(acc.getIban().getValue(), acc.getBalance().getAmount(), acc.getBalance().getCurrency()))
                        .collect(Collectors.toList());
        document.setAccounts(accountDocuments);
        repository.save(document);
        return true;
    }
}
