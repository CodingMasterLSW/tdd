package com.example.practiceTdd.chap03;

import java.time.LocalDate;

public class ExpireDateCalculator {

    public LocalDate calculatorExpiryDate(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }
}
