package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.credentials.Payment;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface PaymentRepository extends RepositoryGI<Payment, String> {
    ArrayList<Payment> getAllPayments();
}
