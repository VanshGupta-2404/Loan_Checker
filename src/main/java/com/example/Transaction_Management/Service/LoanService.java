package com.example.Transaction_Management.Service;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import com.example.Transaction_Management.Entity.Loan;
import com.example.Transaction_Management.Repository.LoanRepository;
import com.example.Transaction_Management.DTO.ExternalLoanResponse;
import com.example.Transaction_Management.DTO.Emi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanIntegrationService loanIntegrationService;


    private String convertMonthToDate(String monthYear) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

        // 🔥 Use YearMonth instead of LocalDate
        YearMonth yearMonth = YearMonth.parse(monthYear, formatter);

        // convert to first day of month
        LocalDate date = yearMonth.atDay(1);

        return date.toString();
    }
    public Loan getLoanDetails(String loanId) {

        ExternalLoanResponse response = loanIntegrationService.getLoanFromExternal(loanId);

        Loan loan = new Loan();

        loan.setLoanAccountNumber(response.getLoanAccountNumber());

        for (Emi emi : response.getEmiDetails()) {
            if (emi.isDueStatus()) {
                loan.setDueDate(convertMonthToDate(emi.getMonth()));
                loan.setEmiAmount(emi.getEmiAmount());
                break;
            }
        }

        loanRepository.save(loan);

        return loan;
    }
}