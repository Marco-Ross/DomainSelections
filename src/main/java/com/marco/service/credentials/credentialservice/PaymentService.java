package com.marco.service.credentials.credentialservice;

import com.marco.domain.credentials.Payment;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface PaymentService extends ServiceGI<Payment, String> {
    ArrayList<Payment> getAllPayments();
}
