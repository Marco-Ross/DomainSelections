package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.Payment;
import com.marco.factory.actors.CustomerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentFactoryTest {

    @Test
    public void getPayment() {
        int paymentID = 20;
        double amount = 200;

        Payment payment = PaymentFactory.buildPayment(paymentID, amount, "45878968958");
        assertEquals(amount, payment.getAmount(), 0.1);
    }
}