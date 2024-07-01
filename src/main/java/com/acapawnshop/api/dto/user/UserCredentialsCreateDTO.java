package com.acapawnshop.api.dto.user;

import com.acapawnshop.api.dto.CredentialsCreateDTO;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeName("user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialsCreateDTO implements CredentialsCreateDTO {
    private String userName;
    private String psswd;
}
