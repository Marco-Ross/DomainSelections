package com.marco.factory.bookings;

import com.marco.domain.bookings.Refund;

public class RefundFactory {
    public static Refund getRefund(double refundAmount, int customerIdNumber){
        return new Refund.Builder().refundAmount(refundAmount)
                .customerIdNumber(customerIdNumber)
                .build();
    }
}
