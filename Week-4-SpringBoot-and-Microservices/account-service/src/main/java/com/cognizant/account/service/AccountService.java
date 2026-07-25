package com.cognizant.account.service;

import com.cognizant.account.dto.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account getAccount(String number) {
        return new Account(number, "Savings", 234343);
    }
}
