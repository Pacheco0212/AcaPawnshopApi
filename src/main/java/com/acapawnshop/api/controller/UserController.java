package com.acapawnshop.api.controller;

import com.acapawnshop.api.dto.CredentialsCreateDTO;
import com.acapawnshop.api.dto.UserCreateDTO;
import com.acapawnshop.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/signIn")
    public void userSignIn(@RequestBody @Valid CredentialsCreateDTO request, @RequestParam Long userId){

        userService.signInUser(request, userId);
    }
}
