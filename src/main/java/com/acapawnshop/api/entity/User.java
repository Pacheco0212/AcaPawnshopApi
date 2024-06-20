package com.acapawnshop.api.entity;

import com.acapawnshop.api.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String email;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Bank> banks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Credentials> credentials = new ArrayList<>();

    public User(UserDTO userDTO) {
        this.names = userDTO.names();
        this.paternalSurname = userDTO.paternalSurname();
        this.maternalSurname = userDTO.maternalSurname();
        this.email = userDTO.email();
        this.phoneNumber = userDTO.phoneNumber();
    }

    public void addAddress(Address address) {
        address.setUser(this);
        this.addresses.add(address);
    }

    public void addFinance(Bank bank) {
        bank.setUser(this);
        this.banks.add(bank);
    }

    public void addCredentials(Credentials credentials) {
        credentials.setUser(this);
        this.credentials.add(credentials);
    }

}
