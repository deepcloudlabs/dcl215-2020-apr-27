package com.example.banking.core.application;

import com.example.banking.core.domain.Iban;
import com.example.banking.core.domain.Money;
import com.example.banking.core.domain.TcKimlikNo;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public interface CustomerApplication {
    boolean transferMoney(TcKimlikNo of, Iban tr1, Iban tr2, Money of1);
}
