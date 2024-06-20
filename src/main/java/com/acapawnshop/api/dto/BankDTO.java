package com.acapawnshop.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record BankDTO(

        @NotBlank(message = "RFC cannot be blank")
        @Pattern(regexp = "[A-Za-z]{3,4}[0-9]{6}[A-Za-z0-9]{3}", message = "RFC must have the correct format")
        String RFC,
        @Pattern(regexp = "\\d{10,20}", message = "Bank account number must be between 10 and 20 digits")
        String bankAccount) {
}
