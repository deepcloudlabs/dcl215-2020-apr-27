package com.example.banking.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customers")
public class CustomerDocument {
    @Id
    private String identity;
    private String fullname;
    private List<AccountDocument> accountDocuments;

    public CustomerDocument() {
    }

    public CustomerDocument(String identity, String fullname) {
        this.identity = identity;
        this.fullname = fullname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<AccountDocument> getAccounts() {
        return accountDocuments;
    }

    public void setAccounts(List<AccountDocument> accountDocuments) {
        this.accountDocuments = accountDocuments;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identity='" + identity + '\'' +
                ", fullname='" + fullname + '\'' +
                ", accounts=" + accountDocuments +
                '}';
    }
}
