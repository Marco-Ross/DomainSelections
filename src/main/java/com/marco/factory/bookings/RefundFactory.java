package com.marco.factory.bookings;

import com.marco.domain.actors.Customer;
import com.marco.domain.bookings.Refund;
import com.marco.domain.credentials.LoginDetail;

public class RefundFactory {
    public static Refund getRefund(double refundAmount, LoginDetail loginDetail){
        return new Refund.Builder().refundAmount(refundAmount)
                .build();
    }
}
