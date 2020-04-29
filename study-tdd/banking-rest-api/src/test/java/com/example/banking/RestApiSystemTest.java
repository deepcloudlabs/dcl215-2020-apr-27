package com.example.banking;

import com.example.banking.core.domain.*;
import com.example.banking.dto.TransferRequest;
import com.example.banking.repository.CustomerMongoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BankingRestApiApplication.class
)
@AutoConfigureMockMvc
public class RestApiSystemTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    CustomerMongoRepository repository;

    @BeforeEach
    void createTestCustomer() {
        var customer = new Customer(TcKimlikNo.of("84419540678"),
                "Jack Bauer");
        customer.addAccount(new Account(Iban.of("TR150006288538595565372934"), Money.of(1_000_000., MoneyCurrency.TL)));
        customer.addAccount(new Account(Iban.of("TR640006273424738347266155"), Money.of(2_000_000., MoneyCurrency.TL)));
        repository.save(customer);
    }

    @Test
    void transferMoneyBetweenAccountShouldSuccess() throws Throwable {
        TransferRequest request =
                new TransferRequest("TR150006288538595565372934","TL",
                        "TR640006273424738347266155","TL",100_000.);
        mvc.perform(post("/transfers/84419540678")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))) // exercise method
                .andExpect(status().isOk())
                .andExpect(jsonPath("status",is("Ok")));
    }

    @Test
    void transferMoneyBetweenAccountShouldFail() throws Throwable {
        TransferRequest request =
                new TransferRequest("TR150006288538595565372934","TL",
                        "TR640006273424738347266155","TL",100_000.);
        mvc.perform(post("/transfers/27164342098")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))) // exercise method
                .andExpect(status().isOk())
                .andExpect(jsonPath("status",is("Failed")));
    }
}
