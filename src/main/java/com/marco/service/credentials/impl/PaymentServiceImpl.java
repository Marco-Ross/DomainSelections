package com.marco.service.credentials.impl;

import com.marco.domain.credentials.Payment;
import com.marco.repository.credentials.credentialrepo.PaymentRepository;
import com.marco.repository.credentials.impl.PaymentRepositoryImpl;
import com.marco.service.credentials.credentialservice.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    @Qualifier("PaymentRepoImpl")
    private PaymentRepository repository;

    @Override
    public ArrayList<Payment> getAllPayments() {
        return this.repository.getAllPayments();
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.create(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.update(payment);
    }

    @Override
    public void delete(String payment) {
        this.repository.delete(payment);
    }

    @Override
    public Payment read(String payment) {
        return this.repository.read(payment);
    }
}
