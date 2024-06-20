package com.acapawnshop.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(

        @NotBlank(message = "Names cannot be blank")
        String names,
        @NotBlank(message = "Paternal surname cannot be blank")
        String paternalSurname,
        @NotBlank(message = "Maternal surname cannot be blank")
        String maternalSurname,
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        String email,
        @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
        String phoneNumber) {
}
