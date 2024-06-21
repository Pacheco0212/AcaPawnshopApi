package com.acapawnshop.api.dto.admin;

import jakarta.validation.constraints.NotBlank;

public record AdminLoginDTO(
        @NotBlank
        String pssdw) {
}
