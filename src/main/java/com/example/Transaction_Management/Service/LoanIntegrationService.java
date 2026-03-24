package com.example.Transaction_Management.Service;

import com.example.Transaction_Management.DTO.ExternalLoanResponse;
import com.example.Transaction_Management.Entity.Loan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoanIntegrationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ExternalLoanResponse getLoanFromExternal(String loanId) {
        String url = "http://demo9993930.mockable.io/loanaccount/" + loanId;
        return restTemplate.getForObject(url, ExternalLoanResponse.class);
    }
}