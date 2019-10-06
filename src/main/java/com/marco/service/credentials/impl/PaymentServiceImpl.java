package com.marco.service.credentials.impl;

import com.marco.domain.credentials.Payment;
import com.marco.repository.credentials.credentialrepo.PaymentRepository;
import com.marco.service.credentials.credentialservice.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository repository;

    @Override
    public ArrayList<Payment> getAllPayments() {
        return (ArrayList<Payment>) this.repository.findAll();
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public void delete(Integer payment) {
        this.repository.deleteById(payment);
    }

    @Override
    public Optional<Payment> read(Integer payment) {
        return this.repository.findById(payment);
    }
}
