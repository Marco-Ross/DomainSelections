package com.marco.service.credentials.credentialservice;

import com.marco.domain.credentials.Payment;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface PaymentService extends ServiceGI<Payment, Integer, Optional<Payment>> {
    ArrayList<Payment> getAllPayments();
}
