package com.acapawnshop.api.service;

import com.acapawnshop.api.entity.AdminCredentials;
import com.acapawnshop.api.repository.AdminCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminCredentialsRepository adminCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String adminname) throws UsernameNotFoundException {
        AdminCredentials adminCredentials = adminCredentialsRepository.findByAdminName(adminname)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found with username: " + adminname));

        return org.springframework.security.core.userdetails.User.builder()
                .username(adminCredentials.getAdminName())
                .password(adminCredentials.getPsswd())
                .roles("ADMIN")
                .build();
    }
}
