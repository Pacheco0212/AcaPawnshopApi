package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
