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

        LocalDate billingDate2 = LocalDate.of(2019,5,5);
        int payAmount2 = 10_000;

        ExpireDateCalculator cal2 = new ExpireDateCalculator();
        LocalDate expireDate2 = cal2.calculatorExpiryDate(billingDate2, payAmount2);

        assertEquals(expireDate2, LocalDate.of(2019,6,5));

    }
}
