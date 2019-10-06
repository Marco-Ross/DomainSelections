package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.Payment;

public class PaymentFactory {
    public static Payment buildPayment(int paymentID, double amount, String customer){
        return new Payment.Builder().paymentID(paymentID)
                .amount(amount)
                .idNumber(customer)
                .build();
    }
}
