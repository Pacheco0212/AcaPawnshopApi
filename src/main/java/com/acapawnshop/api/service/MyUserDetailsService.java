package com.acapawnshop.api.service;

import com.acapawnshop.api.entity.AdminCredentials;
import com.acapawnshop.api.entity.Credentials;
import com.acapawnshop.api.repository.AdminCredentialsRepository;
import com.acapawnshop.api.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private AdminCredentialsRepository adminCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials credentials = credentialsRepository.findByUserName(username)
                .orElse(null);

        if(credentials != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(credentials.getUserName())
                    .password(credentials.getPsswd())
                    .roles("USER")
                    .build();
        }

        AdminCredentials adminCredentials = adminCredentialsRepository.findByAdminName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(adminCredentials.getAdminName())
                .password(adminCredentials.getPsswd())
                .roles("ADMIN")
                .build();
    }
}
