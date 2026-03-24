package com.example.Transaction_Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Loan {

    @Id
    private String loanAccountNumber;

    private String dueDate;
    private double emiAmount;

    // Getter and Setter for loanAccountNumber
    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    // Getter and Setter for dueDate
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // Getter and Setter for emiAmount
    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }
}