package com.acapawnshop.api.dto.admin;
import jakarta.validation.constraints.NotBlank;

public record AdminCredentialsDTO(
        @NotBlank
        String adminName,
        @NotBlank
        String psswd) {
}
