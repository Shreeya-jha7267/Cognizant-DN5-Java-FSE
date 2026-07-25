package com.cognizant.composite.controller;

import com.cognizant.composite.dto.CustomerDetails;
import com.cognizant.composite.service.CompositeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CompositeController {

    private final CompositeService compositeService;

    public CompositeController(CompositeService compositeService) {
        this.compositeService = compositeService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<CustomerDetails> getCustomerDetails(@PathVariable String number) {
        return ResponseEntity.ok(compositeService.getCustomerDetails(number));
    }
}
