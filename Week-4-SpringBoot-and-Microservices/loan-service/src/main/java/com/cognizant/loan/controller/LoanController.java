package com.cognizant.loan.controller;

import com.cognizant.loan.dto.Loan;
import com.cognizant.loan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<Loan> getLoan(@PathVariable String number) {
        return ResponseEntity.ok(loanService.getLoan(number));
    }
}
