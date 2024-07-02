package org.example.spring_mvc_without_boot.controller;

import org.example.spring_mvc_without_boot.controller.dto.AccountRequestDTO;
import org.example.spring_mvc_without_boot.controller.dto.AccountResponseDTO;
import org.example.spring_mvc_without_boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.saveAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail());
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public AccountResponseDTO getAccount(@PathVariable final Long accountId) {
        return new AccountResponseDTO(accountService.findById(accountId));
    }
}
