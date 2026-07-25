package com.cognizant.composite.service;

import com.cognizant.composite.client.AccountClient;
import com.cognizant.composite.client.LoanClient;
import com.cognizant.composite.dto.Account;
import com.cognizant.composite.dto.CustomerDetails;
import com.cognizant.composite.dto.Loan;
import org.springframework.stereotype.Service;

@Service
public class CompositeService {

    private static final String SAMPLE_LOAN_NUMBER = "H00987987972342";

    private final AccountClient accountClient;
    private final LoanClient loanClient;

    public CompositeService(AccountClient accountClient, LoanClient loanClient) {
        this.accountClient = accountClient;
        this.loanClient = loanClient;
    }

    public CustomerDetails getCustomerDetails(String number) {
        Account account = accountClient.getAccount(number);
        Loan loan = loanClient.getLoan(SAMPLE_LOAN_NUMBER);
        return new CustomerDetails(account, loan);
    }
}
