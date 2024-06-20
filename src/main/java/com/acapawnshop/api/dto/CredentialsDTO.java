package com.acapawnshop.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CredentialsDTO(

        @NotBlank(message = "User name cannot be blank")
        String userName,
        @NotBlank(message = "Password cannot be blank")
        String psswd) {
}
