package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.AdminCredentials;
import com.acapawnshop.api.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminCredentialsRepository extends JpaRepository<AdminCredentials, Long>{
    Optional<AdminCredentials> findByAdminName(@Param("adminName") String adminname);

}
