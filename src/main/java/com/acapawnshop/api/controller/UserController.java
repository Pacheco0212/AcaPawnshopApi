package com.acapawnshop.api.controller;

import com.acapawnshop.api.dto.user.UserCredentialsCreateDTO;
import com.acapawnshop.api.dto.user.JwtResponse;
import com.acapawnshop.api.dto.user.UserCreateDTO;
import com.acapawnshop.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usr")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void userRegister(@RequestBody @Valid UserCreateDTO request) {
        userService.registerUser(request);
    }

}
