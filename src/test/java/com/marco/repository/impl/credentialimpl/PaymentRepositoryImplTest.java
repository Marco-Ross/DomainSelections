package com.marco.repository.impl.credentialimpl;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Payment;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.factory.credentials.PaymentFactory;
import com.marco.repository.repositoryinterfaces.credentialrepo.PaymentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PaymentRepositoryImplTest {
    private PaymentRepository repository;
    private Payment payment;

    @Before
    public void setUp() throws Exception {
        this.repository = PaymentRepositoryImpl.getRepository();
        payment = PaymentFactory.getPayment(50);
        this.repository.create(payment);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Payment> arrayList = repository.getAllPayments();
        arrayList.clear();
    }

    @Test
    public void getAllPayments() {
        ArrayList<Payment> arrayList = repository.getAllPayments();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Payment payment = PaymentFactory.getPayment(50);
        Payment paymentTest = this.repository.create(payment);

        Assert.assertEquals(payment, paymentTest);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
        repository.delete(payment);
        ArrayList<Payment> payments = repository.getAllPayments();
        Assert.assertEquals(0, payments.size());
    }

    @Test
    public void read() {
    }
}