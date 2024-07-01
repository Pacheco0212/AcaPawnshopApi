package com.acapawnshop.api.controller;

import com.acapawnshop.api.dto.admin.AdminCredentialsCreateDTO;
import com.acapawnshop.api.dto.user.JwtResponse;
import com.acapawnshop.api.dto.admin.AdminCreateDTO;
import com.acapawnshop.api.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public void adminRegister(@RequestBody @Valid AdminCreateDTO request) {
        adminService.registerAdmin(request);
    }

}
