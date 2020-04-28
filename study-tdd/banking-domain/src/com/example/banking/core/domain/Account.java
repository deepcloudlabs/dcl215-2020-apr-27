package com.example.banking.core.domain;
// Refactoring
public class Account { // Entity -> Identity
    private final String iban; // identity -> final
    private double balance;

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }
}
