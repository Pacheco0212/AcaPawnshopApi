package com.acapawnshop.api.repository;

import com.acapawnshop.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
