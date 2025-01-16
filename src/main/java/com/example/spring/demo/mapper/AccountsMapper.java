package com.example.spring.demo.mapper;

import com.example.spring.demo.dto.AccountDto;
import com.example.spring.demo.entity.Account;

public class AccountsMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
    }
}
