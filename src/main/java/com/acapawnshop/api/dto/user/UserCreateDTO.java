package com.acapawnshop.api.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    private UserDTO userDTO;
    private AddressDTO addressDTO;
    private BankDTO bankDTO;
}