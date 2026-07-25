package com.cognizant.loan.service;

import com.cognizant.loan.dto.Loan;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public Loan getLoan(String number) {
        return new Loan(number, "Car", 400000, 3258, 18);
    }
}
