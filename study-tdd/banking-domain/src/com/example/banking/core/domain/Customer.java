package com.example.banking.core.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Ubiquitous Language : Customer, Account, Iban, Money, Currency, TcKimlikNo
public class Customer { // Entity -> Entity Root -> Aggregate -> Invariant
    private final TcKimlikNo identity;
    private String fullname;
    private Map<Iban, Account> accounts = new HashMap<>();

    public Customer(TcKimlikNo identity, String fullname) {
        this.identity = identity;
        this.fullname = fullname;
    }

    public TcKimlikNo getIdentity() {
        return identity;
    }

    public String getFullname() {
        return fullname;
    }

    public List<Account> getAccounts() {
        return accounts.values().stream().collect(Collectors.toList());
    }

    public void addAccount(Account account) {
        accounts.put(account.getIban(), account);
    }

    public Optional<Account> findAccountByIban(Iban iban) {
        return Optional.ofNullable(accounts.get(iban));
    }

    public Optional<Account> removeAccountByIban(Iban iban) {
        return Optional.ofNullable(accounts.remove(iban));
    }

    public Map<MoneyCurrency, Optional<Money>> getTotalMoney() {
        return accounts.values().stream().collect(groupingBy(acc -> acc.getBalance().getCurrency(), mapping(Account::getBalance, reducing((total, money) -> total.add(money)))));
    }
}
