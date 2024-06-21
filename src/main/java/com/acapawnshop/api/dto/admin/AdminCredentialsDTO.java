package com.acapawnshop.api.dto.admin;
import jakarta.validation.constraints.NotBlank;

public record AdminCredentialsDTO(
        @NotBlank
        String admin_name,
        @NotBlank
        String psswd) {
}
