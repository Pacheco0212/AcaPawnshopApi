package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    Optional<Credentials> findByUserName(@Param("userName") String username);
}
