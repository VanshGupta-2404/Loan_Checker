package com.example.Transaction_Management.controller;

import com.example.Transaction_Management.Entity.Loan;
import com.example.Transaction_Management.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/{loanId}")
    public Loan getLoan(@PathVariable String loanId) {
        return loanService.getLoanDetails(loanId);
    }
}