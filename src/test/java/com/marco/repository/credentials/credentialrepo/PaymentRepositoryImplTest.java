package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.Payment;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.PaymentFactory;
import com.marco.repository.credentials.impl.PaymentRepositoryImpl;
import com.marco.repository.credentials.credentialrepo.PaymentRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaymentRepositoryImplTest {
    @Autowired
    @Qualifier("PaymentRepoImpl")
    private PaymentRepository repository;
    private Payment payment;

    private Payment getRepo(){
        for(Payment paymentA : repository.getAllPayments()){
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
        ArrayList<Payment> arrayList = repository.getAllPayments();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Payment paymentTest = this.repository.create(payment);
        Assert.assertEquals(payment, paymentTest);
    }

    @Test
    @Ignore
    public void c_update() {
        //Cannot update Payments
    }

    @Test
    public void e_delete() {
        repository.delete(payment.getCustomer().getIdNumber());
        ArrayList<Payment> payments = repository.getAllPayments();
        Assert.assertEquals(0, payments.size());
    }

    @Test
    public void b_read() {
        Payment paymentRead = this.repository.read("12345678910");
        Assert.assertSame(payment.getCustomer().getIdNumber(), paymentRead.getCustomer().getIdNumber());
    }
}