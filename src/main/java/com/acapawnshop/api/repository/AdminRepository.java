package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByAdminId(@Param("adminId") Long adminId);
}
