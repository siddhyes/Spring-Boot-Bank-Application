package com.example.spring.demo.service;

import com.example.spring.demo.dto.AccountDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(@RequestBody AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id ,String amount);
    AccountDto withDraw(Long id ,String amount);
    List<AccountDto> getAllAccount();
    void deleteAccount(Long id);

}
