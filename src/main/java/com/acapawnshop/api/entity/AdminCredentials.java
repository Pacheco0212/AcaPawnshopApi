package com.acapawnshop.api.entity;
import com.acapawnshop.api.dto.admin.AdminCredentialsDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "adminCredentials")
@Entity(name = "AdminCredentials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class AdminCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adminName;
    private String psswd;

    @ManyToOne
    @JoinColumn(name = "admin_Id")
    private Admin admin;

    public AdminCredentials(AdminCredentialsDTO adminCredentialsDTO){
        this.adminName = adminCredentialsDTO.admin_name();
        this.psswd = adminCredentialsDTO.psswd();
    }

}
