package com.neo.bank.api.repository;

import com.neo.bank.api.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByCustomerId(String customerId);
}
