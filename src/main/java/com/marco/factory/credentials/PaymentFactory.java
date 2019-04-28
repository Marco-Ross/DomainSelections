package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Payment;

public class PaymentFactory {
    public static Payment getPayment(double amount){
        return new Payment.Builder().amount(amount)
                .build();
    }
}
