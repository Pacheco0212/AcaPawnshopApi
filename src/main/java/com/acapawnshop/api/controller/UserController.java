package com.acapawnshop.api.controller;

import com.acapawnshop.api.dto.user.CredentialsCreateDTO;
import com.acapawnshop.api.dto.user.JwtResponse;
import com.acapawnshop.api.dto.user.UserCreateDTO;
import com.acapawnshop.api.service.UserService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://acapawnshop.vercel.app")
@RequestMapping("/usr")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void userRegister(@RequestBody @Valid UserCreateDTO request) {

        userService.registerUser(request);
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> userSignIn(@RequestBody @Valid CredentialsCreateDTO request, @RequestParam Long userId){
        String token = userService.signInUser(request, userId);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/logIn")
    public ResponseEntity<JwtResponse> userLogIn(@RequestBody CredentialsCreateDTO request) {
        String token = userService.logInUser(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
