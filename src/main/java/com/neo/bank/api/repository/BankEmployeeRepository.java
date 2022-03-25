package com.neo.bank.api.repository;

import com.neo.bank.api.entity.BankEmployee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankEmployeeRepository extends JpaRepository<BankEmployee,Long> {

    Optional<BankEmployee> findByEmployeeId(String employeeId);
}
