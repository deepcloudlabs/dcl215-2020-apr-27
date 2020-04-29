package com.example.banking;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.domain.Iban;
import com.example.banking.core.domain.Money;
import com.example.banking.core.domain.MoneyCurrency;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.dto.TransferRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
       webEnvironment =  SpringBootTest.WebEnvironment.MOCK,
       classes = BankingRestApiApplication.class
)
@AutoConfigureMockMvc
class BankingRestApiApplicationTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    CustomerApplication customerApplication;

    @Test
    void transferMoneyBetweenAccountShouldSuccess() throws Throwable {
        Mockito.when(customerApplication.transferMoney(
                TcKimlikNo.of("20991137608"),
                Iban.of("TR150006288538595565372934"),
                Iban.of("TR640006273424738347266155"),
                Money.of(1_000, MoneyCurrency.TL)
        )).thenReturn(true);
        TransferRequest request =
                new TransferRequest("TR150006288538595565372934","TL",
                        "TR640006273424738347266155","TL",1_000.);
        mvc.perform(post("/transfers/20991137608")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))) // exercise method
           .andExpect(status().isOk())
           .andExpect(jsonPath("status",is("Ok")));
    }

}
