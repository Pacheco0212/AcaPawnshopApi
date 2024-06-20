package com.acapawnshop.api.entity;

import com.acapawnshop.api.dto.admin.AdminDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "admin")
@Entity(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "adminId")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String email;

    public Admin(AdminDTO adminDTO) {
        this.names = adminDTO.names();
        this.paternalSurname = adminDTO.paternalSurname();
        this.maternalSurname = adminDTO.maternalSurname();
        this.email = adminDTO.email();
    }
}
