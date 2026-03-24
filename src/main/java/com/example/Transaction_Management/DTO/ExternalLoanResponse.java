package com.example.Transaction_Management.DTO;

import java.util.List;

public class ExternalLoanResponse {
    private String loanAccountNumber;
    private List<Emi> emiDetails;

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public List<Emi> getEmiDetails() {
        return emiDetails;
    }

    public void setEmiDetails(List<Emi> emiDetails) {
        this.emiDetails = emiDetails;
    }
}
