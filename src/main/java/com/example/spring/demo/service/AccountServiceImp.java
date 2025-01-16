package com.example.spring.demo.service;

import com.example.spring.demo.dto.AccountDto;
import com.example.spring.demo.entity.Account;
import com.example.spring.demo.exceptionHandler.AccountNotFoundException;
import com.example.spring.demo.exceptionHandler.InsufficientBalanceException;
import com.example.spring.demo.mapper.AccountsMapper;
import com.example.spring.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountsMapper.mapToAccount(accountDto);
        Account response = accountRepository.save(account);
        return AccountsMapper.mapToAccountDto(response);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        return AccountsMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, String amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        double balance = Double.parseDouble(account.getBalance()) + Double.parseDouble(amount);
        account.setBalance(String.valueOf(balance));
        Account savedresposne = accountRepository.save(account);
        return AccountsMapper.mapToAccountDto(savedresposne);
    }

    @Override
    public AccountDto withDraw(Long id, String amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));

        if (Double.parseDouble(amount) > Double.parseDouble(account.getBalance()))
            throw new InsufficientBalanceException("Insufficient balance");
        double totalAmount = Double.parseDouble(account.getBalance()) - Double.parseDouble(amount);
        account.setBalance(String.valueOf(totalAmount));
        Account response = accountRepository.save(account);

        return AccountsMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> list = accountRepository.findAll();
        return list.stream().map((AccountsMapper::mapToAccountDto)).toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).
                orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
         accountRepository.deleteById(id);


    }

}
