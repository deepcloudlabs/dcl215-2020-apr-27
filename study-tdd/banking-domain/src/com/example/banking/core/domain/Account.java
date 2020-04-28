package com.example.banking.core.domain;

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
        if (money.getAmount() > balance.getAmount())
            throw new InsufficientBalanceException();
        this.balance = this.balance.sub(money);
    }
}
