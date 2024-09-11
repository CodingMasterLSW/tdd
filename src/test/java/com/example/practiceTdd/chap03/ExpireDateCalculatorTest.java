package com.example.practiceTdd.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpireDateCalculatorTest {

    @Test
    void pay_10000_Then_One_Month() {
        assertExpireDate(
                PayData.builder()
                        .billingData(LocalDate.of(2019, 3, 1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 4, 1));

        assertExpireDate(
                PayData.builder()
                        .billingData(LocalDate.of(2019, 5, 5))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 6, 5));

    }


    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {

        assertExpireDate(
                PayData.builder()
                        .billingData(LocalDate.of(2019, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 2, 28));

        assertExpireDate(
                PayData.builder()
                        .billingData(LocalDate.of(2019, 5, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 6, 30));

        assertExpireDate(
                PayData.builder()
                        .billingData(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29));

    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부(){
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,31))
                .billingData(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        assertExpireDate(payData, LocalDate.of(2019,3,31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,30))
                .billingData(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        assertExpireDate(payData2, LocalDate.of(2019,3,30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,05,31))
                .billingData(LocalDate.of(2019,06,30))
                .payAmount(10_000)
                .build();

        assertExpireDate(payData3, LocalDate.of(2019,07,31));
    }






    private void assertExpireDate(PayData payData, LocalDate expectedExpireDate) {
        ExpireDateCalculator cal = new ExpireDateCalculator();
        LocalDate realExpireDate = cal.calculatorExpiryDate(payData);
        assertEquals(realExpireDate, expectedExpireDate);
    }
}
