Feature: Customers can transfer money between accounts

  Scenario: Customer can transfer money between his/her accounts
    Given a customer 'Jack Bauer' with identity 93732057916
    And account TR750006254515519259778812 with 10000.0 TL
    And account TR280006283276796827672817 with 5000.0 TL
    When the customer transfers 1000.0 TL from account TR750006254515519259778812 to account TR280006283276796827672817
    Then there is 9000.0 TL in account TR750006254515519259778812 and 6000.0 TL in account TR280006283276796827672817