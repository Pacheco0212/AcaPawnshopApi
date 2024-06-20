package com.acapawnshop.api.controller;

import com.acapawnshop.api.dto.UserCreateDTO;
import com.acapawnshop.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
