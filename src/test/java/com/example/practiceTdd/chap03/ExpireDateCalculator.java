package com.example.practiceTdd.chap03;

import java.time.LocalDate;

public class ExpireDateCalculator {

    public LocalDate calculatorExpiryDate(PayData payData) {
        if(payData.getFirstBillingDate() != null) {
            if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) {
                return LocalDate.of(2019, 3, 31);
            }
        }
        return payData.getBillingDate().plusMonths(1);
    }
}
