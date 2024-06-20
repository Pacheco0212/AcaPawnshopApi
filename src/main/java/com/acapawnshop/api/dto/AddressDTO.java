package com.acapawnshop.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank(message = "Street cannot be blank")
        String street,
        @NotBlank(message = "Number cannot be blank")
        String num,
        @NotBlank(message = "Post code cannot be blank")
        String CP,
        @NotBlank(message = "Municipality cannot be blank")
        String municipality,
        @NotBlank(message = "State cannot be blank")
        String state) {
}
