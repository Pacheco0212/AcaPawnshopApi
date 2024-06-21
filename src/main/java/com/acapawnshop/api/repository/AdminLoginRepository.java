package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLoginRepository extends JpaRepository<AdminLogin,Long> {
}
