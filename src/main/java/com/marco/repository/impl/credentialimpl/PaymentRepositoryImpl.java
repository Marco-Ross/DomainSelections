package com.marco.repository.impl.credentialimpl;

import com.marco.domain.credentials.Payment;
import com.marco.repository.repositoryinterfaces.credentialrepo.PaymentRepository;

import java.util.ArrayList;

public class PaymentRepositoryImpl implements PaymentRepository {
    private static PaymentRepositoryImpl repository = null;
    private ArrayList<Payment> payments;

    private PaymentRepositoryImpl(){
        this.payments = new ArrayList<>();
    }

    public static PaymentRepositoryImpl getRepository(){
        if(repository == null) repository = new PaymentRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Payment> getAllPayments() {
        return this.payments;
    }

    @Override
    public Payment create(Payment payment) {
        this.payments.add(payment);
        return payment;
    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }

    @Override
    public void delete(Payment payment) {
        this.payments.remove(payment);
    }

    @Override
    public Payment read(String customerId) {
        return null;
    }
}
