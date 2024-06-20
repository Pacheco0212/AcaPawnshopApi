package com.acapawnshop.api.dto.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminDTO(
        @NotBlank
        String names,
        @NotBlank
        String paternalSurname,
        @NotBlank
        String maternalSurname,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String state) {
}
