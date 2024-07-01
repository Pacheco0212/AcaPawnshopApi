package com.acapawnshop.api.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserCredentialsDTO(

        @NotBlank(message = "User name cannot be blank")
        String userName,
        @NotBlank(message = "Password cannot be blank")
        String psswd) {
}
