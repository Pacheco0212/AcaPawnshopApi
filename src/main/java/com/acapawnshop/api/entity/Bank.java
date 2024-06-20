package com.acapawnshop.api.entity;

import com.acapawnshop.api.dto.BankDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "userFinance")
@Entity(name = "Bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "financeId")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long financeId;
    private String RFC;
    private String bankAccount;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    public Bank(BankDTO bankDTO) {
        this.RFC = bankDTO.RFC();
        this.bankAccount = bankDTO.bankAccount();
    }
}
