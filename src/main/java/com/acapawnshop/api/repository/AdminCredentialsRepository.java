package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.AdminCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminCredentialsRepository extends JpaRepository<AdminCredentials, Long>{
}
