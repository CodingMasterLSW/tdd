package com.example.practiceTdd.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpireDateCalculatorTest {

    @Test
    void pay_10000_Then_One_Month(){
        assertExpireDate(
                LocalDate.of(2019,3,1), 10_000,
                LocalDate.of(2019,4,1));

        assertExpireDate(
                LocalDate.of(2019,5,5), 10_000,
                LocalDate.of(2019,6,5));

    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음(){
        assertExpireDate(
                LocalDate.of(2019,1,31), 10_000,
                LocalDate.of(2019,2,28));

        assertExpireDate(
                LocalDate.of(2019,5,31), 10_000,
                LocalDate.of(2019,6,30)
        );

        assertExpireDate(
                LocalDate.of(2020,1,31), 10_000,
                LocalDate.of(2020,2,29)
        );

    }

    private void assertExpireDate(LocalDate billingDate, int payAmount, LocalDate expectedExpireDate){
        ExpireDateCalculator cal = new ExpireDateCalculator();
        LocalDate realExpireDate = cal.calculatorExpiryDate(billingDate, payAmount);
        assertEquals(realExpireDate, expectedExpireDate);
    }
}
