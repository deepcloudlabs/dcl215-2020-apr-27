package com.example.banking.core.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public final class Money {
    private static final Money NO_MONEY = new Money(0, MoneyCurrency.TL);// Value Object --> Immutable
    private final double amount;
    private final MoneyCurrency currency;

    private Money(double amount, MoneyCurrency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money of(double amount, MoneyCurrency currency) {
        if (amount < 0) throw new IllegalArgumentException("Money value must be positive");
        if (amount == 0.) return NO_MONEY;
        return new Money(amount, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (Double.compare(money.amount, amount) != 0) return false;
        return currency == money.currency;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    public double getAmount() {
        return amount;
    }

    public MoneyCurrency getCurrency() {
        return currency;
    }

    public Money add(Money money) {
        requireSameCurrency(this.currency, money.currency);
        return Money.of(amount + money.amount, currency);
    }

    public Money sub(Money money) {
        requireSameCurrency(this.currency, money.currency);
        return Money.of(amount - money.amount, currency);
    }

    private void requireSameCurrency(MoneyCurrency currency, MoneyCurrency other) {
        if (currency != other) throw new IllegalArgumentException("Currencies must be equal");
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }

}
