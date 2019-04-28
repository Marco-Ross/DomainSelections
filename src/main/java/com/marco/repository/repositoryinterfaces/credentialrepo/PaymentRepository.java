package com.marco.repository.repositoryinterfaces.credentialrepo;

import com.marco.domain.credentials.Payment;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface PaymentRepository extends RepositoryGI<Payment, String> {
    ArrayList<Payment> getAllPayments();
}
