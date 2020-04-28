package com.example.banking.core.application.impl;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.domain.Iban;
import com.example.banking.core.domain.Money;
import com.example.banking.core.domain.TcKimlikNo;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class BusinessCustomerApplication implements CustomerApplication {
    @Override
    public boolean transferMoney(TcKimlikNo of, Iban tr1, Iban tr2, Money of1) {
        return false;
    }
}
