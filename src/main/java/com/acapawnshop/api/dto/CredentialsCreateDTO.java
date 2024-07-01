package com.acapawnshop.api.dto;

import com.acapawnshop.api.dto.admin.AdminCredentialsCreateDTO;
import com.acapawnshop.api.dto.user.UserCredentialsCreateDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserCredentialsCreateDTO.class, name = "user"),
        @JsonSubTypes.Type(value = AdminCredentialsCreateDTO.class, name = "admin")
})
public interface CredentialsCreateDTO {
}
