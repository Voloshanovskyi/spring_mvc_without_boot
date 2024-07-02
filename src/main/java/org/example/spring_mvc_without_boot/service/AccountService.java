package org.example.spring_mvc_without_boot.service;

import org.example.spring_mvc_without_boot.entity.Account;
import org.example.spring_mvc_without_boot.repository.AccountRepository;

public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Long saveAccount(String name, String email){
        return accountRepository.save(new Account(name, email)).getAccountId();
    }
    public Account findById(Long accountId){
        return accountRepository.findById(accountId).orElseThrow();
    }
}
