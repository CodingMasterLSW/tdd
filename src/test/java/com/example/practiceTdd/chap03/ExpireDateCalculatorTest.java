package com.example.practiceTdd.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpireDateCalculatorTest {

    @Test
    void pay_10000_Then_One_Month(){
        LocalDate billingDate = LocalDate.of(2019,3,1);
        int payAmount = 10_000;

        ExpireDateCalculator cal = new ExpireDateCalculator();
        LocalDate expireDate = cal.calculatorExpiryDate(billingDate, payAmount);

        assertEquals(expireDate, LocalDate.of(2019,4,1));
    }
}
