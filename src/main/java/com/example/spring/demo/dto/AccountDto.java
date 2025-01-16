package com.example.spring.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Data
@AllArgsConstructor
@Setter
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private String balance;

}
