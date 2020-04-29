package com.example.banking.repository;

import com.example.banking.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerMongoCrudRepository extends MongoRepository<CustomerDocument, String> {
    Optional<CustomerDocument> findOneByIdentity(String identity);
    List<CustomerDocument> findAllByFullname(String fullname);
}
