package com.example.practiceTdd.chap03;

import java.time.LocalDate;

public class ExpireDateCalculator {

    public LocalDate calculatorExpiryDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
}
