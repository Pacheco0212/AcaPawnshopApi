package com.acapawnshop.api.entity;

import com.acapawnshop.api.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "address")
@Entity(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "addressId")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String num;
    private String CP;
    private String municipality;
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.num = addressDTO.num();
        this.CP = addressDTO.CP();
        this.municipality = addressDTO.municipality();
        this.state = addressDTO.state();
    }
}
