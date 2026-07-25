package com.cognizant.composite.client;

import com.cognizant.composite.dto.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "LOAN-SERVICE")
public interface LoanClient {

    @GetMapping("/loans/{number}")
    Loan getLoan(@PathVariable String number);
}
