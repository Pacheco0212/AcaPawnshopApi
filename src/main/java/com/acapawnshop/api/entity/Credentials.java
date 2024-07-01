package com.acapawnshop.api.entity;

import com.acapawnshop.api.dto.user.UserCredentialsDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "userCredentials")
@Entity(name = "Credentials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String psswd;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    public Credentials(UserCredentialsDTO userCredentialsDTO){
        this.userName = userCredentialsDTO.userName();
        this.psswd = userCredentialsDTO.psswd();
    }
}
