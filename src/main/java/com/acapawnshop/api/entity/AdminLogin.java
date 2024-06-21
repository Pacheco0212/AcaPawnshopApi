package com.acapawnshop.api.entity;

import com.acapawnshop.api.dto.admin.AdminLoginDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "admin_login")
@Entity(name = "Admin_login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "loginID")

public class AdminLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loginID;
    private String psswd;

    @ManyToOne
    @JoinColumn(name = "admin_Id")
    private Admin admin;

    public AdminLogin(AdminLoginDTO adminLoginDTO) {
        this.psswd = adminLoginDTO.pssdw();

    }

}
