package com.example.banking.controller;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.domain.Iban;
import com.example.banking.core.domain.Money;
import com.example.banking.core.domain.MoneyCurrency;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.dto.TransferRequest;
import com.example.banking.dto.TransferResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("transfers")
public class CustomerApplicationController {
    private CustomerApplication customerApplication;

    public CustomerApplicationController(CustomerApplication customerApplication) {
        this.customerApplication = customerApplication;
    }

    // POST http(s)://localhost:9001/banking/api/v1/transfers
    @PostMapping("{identity}")
    public TransferResponse transfer(@PathVariable String identity,
                                     @RequestBody TransferRequest request){
        boolean success = false;
        try{
            success = customerApplication.transferMoney(TcKimlikNo.of(identity),
                    Iban.of(request.getFromIban()),
                    Iban.of(request.getToIban()),
                    Money.of(request.getAmount(), MoneyCurrency.valueOf(request.getFromCurrency()))
            );
        } catch (IllegalArgumentException e){ }
        return new TransferResponse(success ? "Ok" : "Failed");
    }
}
