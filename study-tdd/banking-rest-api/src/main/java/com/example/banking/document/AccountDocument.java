package com.example.banking.document;

import com.example.banking.core.domain.MoneyCurrency;

public class AccountDocument {
    private String iban;
    private double balance;
    private MoneyCurrency currency;

    public AccountDocument() {
    }

    public AccountDocument(String iban, double balance, MoneyCurrency currency) {
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public MoneyCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(MoneyCurrency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
