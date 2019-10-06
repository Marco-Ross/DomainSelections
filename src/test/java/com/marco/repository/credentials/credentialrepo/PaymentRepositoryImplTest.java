//package com.marco.repository.credentials.credentialrepo;
//
//import com.marco.domain.actors.Customer;
//import com.marco.domain.credentials.Payment;
//import com.marco.factory.actors.CustomerFactory;
//import com.marco.factory.credentials.PaymentFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PaymentRepositoryImplTest {
//    @Autowired
//    private PaymentRepository repository;
//    private Payment payment;
//
//    private Payment getRepo(){
//        for(Payment paymentA : repository.findAll()){
//            if(paymentA.getCustomerId().equals(payment.getCustomerId())){
//                return paymentA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        payment = PaymentFactory.buildPayment(120, 50, "12345678910");
//    }
//
//    @Test
//    public void d_getAllPayments() {
//        ArrayList<Payment> arrayList = (ArrayList<Payment>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Payment paymentTest = this.repository.save(payment);
//        Assert.assertEquals(payment, paymentTest);
//    }
//
//    @Test
//    @Ignore
//    public void c_update() {
//        //Cannot update Payments
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(payment.getPaymentID());
//        ArrayList<Payment> payments = (ArrayList<Payment>) repository.findAll();
//        Assert.assertEquals(0, payments.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Payment> paymentRead = this.repository.findById(120);
//        Assert.assertTrue(paymentRead.isPresent());
//        Assert.assertSame(payment.getCustomerId(), paymentRead.get().getCustomerId());
//    }
//}