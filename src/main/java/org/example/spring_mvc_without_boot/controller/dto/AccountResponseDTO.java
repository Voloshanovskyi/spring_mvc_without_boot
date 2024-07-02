package org.example.spring_mvc_without_boot.controller.dto;

import org.example.spring_mvc_without_boot.entity.Account;

public class AccountResponseDTO {
    private Long accountId;
    private String name;
    private String email;

    public AccountResponseDTO(final Long accountId, final String name, final String email) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
    }

    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(final Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
