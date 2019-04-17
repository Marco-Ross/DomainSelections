package com.marco.factory.credentials;

import com.marco.domain.credentials.Payment;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentFactoryTest {

    @Test
    public void getPayment() {
        double amount = 200;
        Payment payment = PaymentFactory.getPayment(amount);
        assertNotEquals(payment.getAmount(), 200);
    }
}