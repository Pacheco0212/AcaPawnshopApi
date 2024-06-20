package com.acapawnshop.api.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminCreateDTO {
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String email;
    private String state;
}
