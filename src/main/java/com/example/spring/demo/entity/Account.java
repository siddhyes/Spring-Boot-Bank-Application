package com.example.spring.demo.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@Entity()
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    private String balance;


}
