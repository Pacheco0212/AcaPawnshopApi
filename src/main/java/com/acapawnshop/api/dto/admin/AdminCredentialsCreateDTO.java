package com.acapawnshop.api.dto.admin;

import com.acapawnshop.api.dto.CredentialsCreateDTO;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeName("admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AdminCredentialsCreateDTO implements CredentialsCreateDTO {
    private String adminName;
    private String psswd;
}
