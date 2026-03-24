package com.example.Transaction_Management.Service;

import com.example.Transaction_Management.Entity.Loan;
import com.example.Transaction_Management.Repository.LoanRepository;
import com.example.Transaction_Management.DTO.ExternalLoanResponse;
import com.example.Transaction_Management.DTO.Emi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanIntegrationService loanIntegrationService;

    public Loan getLoanDetails(String loanId) {

        ExternalLoanResponse response = loanIntegrationService.getLoanFromExternal(loanId);

        Loan loan = new Loan();

        loan.setLoanAccountNumber(response.getLoanAccountNumber());

        for (Emi emi : response.getEmiDetails()) {
            if (emi.isDueStatus()) {
                loan.setDueDate(emi.getMonth());
                loan.setEmiAmount(emi.getEmiAmount());
                break;
            }
        }

        loanRepository.save(loan);

        return loan;
    }
}