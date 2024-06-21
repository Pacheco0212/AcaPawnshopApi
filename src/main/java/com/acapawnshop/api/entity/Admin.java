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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", orphanRemoval = true)
    private List<AdminCredentials> adminCredentials = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", orphanRemoval = true)
    private List<AdminLogin> logins = new ArrayList<>();

    public Admin(AdminDTO adminDTO) {
        this.names = adminDTO.names();
        this.paternalSurname = adminDTO.paternalSurname();
        this.maternalSurname = adminDTO.maternalSurname();
        this.email = adminDTO.email();
    }

    public void addAdminCredentials(AdminCredentials adminCredentials) {
        adminCredentials.setAdmin(this);
        this.adminCredentials.add(adminCredentials);
    }

    public void addAdminLogin(AdminLogin adminLogin) {
        adminLogin.setAdmin(this);
        this.logins.add(adminLogin);
    }
}
