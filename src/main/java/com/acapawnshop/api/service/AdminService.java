package com.acapawnshop.api.service;

import com.acapawnshop.api.dto.admin.AdminCreateDTO;
import com.acapawnshop.api.dto.admin.AdminCredentialsCreateDTO;

import com.acapawnshop.api.entity.Admin;
import com.acapawnshop.api.entity.AdminCredentials;


import com.acapawnshop.api.repository.AdminRepository;
import com.acapawnshop.api.repository.AdminCredentialsRepository;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminCredentialsRepository adminCredentialsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyAdminDetailsService adminDetailsService;


    private final String secretKey = "2bd3c48b-eed0-4c14-84d0-3dc5c9d902c5";
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());



    public void registerAdmin(AdminCreateDTO request){

        Admin admin = new Admin(request.getAdminDTO());
        adminRepository.save(admin);
    }


    public String signInAdmin(AdminCredentialsCreateDTO request, Long adminId){
        Admin admin = adminRepository.findByAdminId(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));

        AdminCredentials adminCredentials = new AdminCredentials();
        adminCredentials.setAdminName(request.getAdminName());
        String encodedPassword = passwordEncoder.encode(request.getPsswd());
        adminCredentials.setPsswd(encodedPassword);
        adminCredentials.setAdmin(admin);

        admin.addAdminCredentials(adminCredentials);
        adminCredentialsRepository.save(adminCredentials);

        //Admin Authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getAdminName(), request.getPsswd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Load admin details
        final UserDetails userDetails = adminDetailsService.loadUserByUsername(request.getAdminName());

         //Create and return token jwt
          return generateToken(userDetails);
    }




    public String logInAdmin(AdminCredentialsCreateDTO request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getAdminName(),request.getPsswd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = adminDetailsService.loadUserByUsername(request.getAdminName());
        return generateToken(userDetails);
    }

    private String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //horas
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .compact();
    }



}
