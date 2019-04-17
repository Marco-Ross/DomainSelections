package com.marco.factory.bookings;

import com.marco.domain.bookings.Refund;
import org.junit.Test;

import static org.junit.Assert.*;

public class RefundFactoryTest {

    @Test
    public void getRefund() {
        double refundAmount = 80.50;
        int customerIdNumber = 1234;
        Refund refund = RefundFactory.getRefund(refundAmount, customerIdNumber);
        assertEquals(refund.getCustomerIdNumber(), 1234);
    }
}