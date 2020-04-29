package com.example.banking.core.domain;

import java.util.Objects;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Refactoring
public class Account { // Entity -> Identity
    private final Iban iban; // identity -> final
    private Money balance; // Value object, double -> Money -> Value object

    public Account(Iban iban, Money balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public Iban getIban() {
        return iban;
    }

    public Money getBalance() {
        return balance;
    }

    public void deposit(Money money) {
        this.balance = this.balance.add(money);
    }

    public void withdraw(Money money) {
        if (money.getAmount()>balance.getAmount())
            throw new InsufficientBalanceException();
        this.balance = this.balance.sub(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!Objects.equals(iban, account.iban)) return false;
        return Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        int result = iban != null ? iban.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
