package com.acapawnshop.api.controller;

import com.acapawnshop.api.dto.CredentialsCreateDTO;
import com.acapawnshop.api.dto.admin.AdminCredentialsCreateDTO;
import com.acapawnshop.api.dto.user.UserCredentialsCreateDTO;
import com.acapawnshop.api.dto.user.JwtResponse;
import com.acapawnshop.api.service.AdminService;
import com.acapawnshop.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> signIn(@RequestBody CredentialsCreateDTO request, @RequestParam Long id){
        String token;

        if(request instanceof UserCredentialsCreateDTO) {
            token = userService.signInUser((UserCredentialsCreateDTO) request, id);
        } else if(request instanceof AdminCredentialsCreateDTO) {
            token = adminService.signInAdmin((AdminCredentialsCreateDTO) request, id);
        } else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/logIn")
    public ResponseEntity<JwtResponse> logIn(@RequestBody CredentialsCreateDTO request){
        String token;

        if(request instanceof UserCredentialsCreateDTO) {
            token = userService.logInUser((UserCredentialsCreateDTO) request);
        } else if(request instanceof AdminCredentialsCreateDTO) {
            token = adminService.logInAdmin((AdminCredentialsCreateDTO) request);
        } else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
