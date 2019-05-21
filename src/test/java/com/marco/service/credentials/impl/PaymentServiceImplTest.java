package com.marco.service.credentials.impl;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.Payment;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.PaymentFactory;
import com.marco.service.credentials.credentialservice.PaymentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaymentServiceImplTest {
    @Autowired
    @Qualifier("PaymentServiceImpl")
    private PaymentService service;
    private Payment payment;

    private Payment getRepo(){
        for(Payment paymentA : service.getAllPayments()){
            if(paymentA.getCustomer().getIdNumber().equals(payment.getCustomer().getIdNumber())){
                return paymentA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 23, "12345678910", 200);
        payment = PaymentFactory.buildPayment(50, customer);
    }

    @Test
    public void d_getAllPayments() {
        ArrayList<Payment> arrayList = service.getAllPayments();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Payment paymentTest = this.service.create(payment);
        Assert.assertEquals(payment, paymentTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        double amount = 300;
        Payment updated = new Payment.Builder().copy(getRepo()).amount(amount).build();

        this.service.update(updated);

        Assert.assertEquals(amount, updated.getAmount(), 0.1);
        System.out.println("Payment updated");
    }

    @Test
    public void e_delete() {
        service.delete(payment.getCustomer().getIdNumber());
        ArrayList<Payment> payments = service.getAllPayments();
        Assert.assertEquals(0, payments.size());
    }

    @Test
    public void b_read() {
        Payment paymentRead = this.service.read("12345678910");
        Assert.assertSame(payment.getCustomer().getIdNumber(), paymentRead.getCustomer().getIdNumber());
    }
}