package com.acapawnshop.api.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CredentialsCreateDTO {

    private String userName;
    private String psswd;
}
