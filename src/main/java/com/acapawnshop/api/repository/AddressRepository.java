package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
