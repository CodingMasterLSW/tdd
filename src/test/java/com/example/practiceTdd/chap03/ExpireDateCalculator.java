package com.example.practiceTdd.chap03;

import java.time.LocalDate;

public class ExpireDateCalculator {

    public LocalDate calculatorExpiryDate(PayData payData) {

        int addedMonths = 1;
        if(payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            if(payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }
}
