package com.example.banking.dto;

public class TransferRequest {
    private final String fromIban;
    private final String fromCurrency;
    private final String toIban;
    private final String toCurrency;
    private final double amount;

    public TransferRequest(String fromIban, String fromCurrency, String toIban, String toCurrency, double amount) {
        this.fromIban = fromIban;
        this.fromCurrency = fromCurrency;
        this.toIban = toIban;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }

    public String getFromIban() {
        return fromIban;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToIban() {
        return toIban;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "fromIban='" + fromIban + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toIban='" + toIban + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
