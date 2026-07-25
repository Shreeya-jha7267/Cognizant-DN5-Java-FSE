package com.cognizant.account.controller;

import com.cognizant.account.dto.Account;
import com.cognizant.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<Account> getAccount(@PathVariable String number) {
        return ResponseEntity.ok(accountService.getAccount(number));
    }
}
