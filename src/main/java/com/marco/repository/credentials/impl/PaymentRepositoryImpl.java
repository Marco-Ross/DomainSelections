//package com.marco.repository.credentials.impl;
//
//import com.marco.domain.credentials.Payment;
//import com.marco.repository.credentials.credentialrepo.PaymentRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//
//@Repository("PaymentRepoImpl")
//public class PaymentRepositoryImpl implements PaymentRepository {
//    private ArrayList<Payment> payments;
//
//    private PaymentRepositoryImpl(){
//        this.payments = new ArrayList<>();
//    }
//
//    @Override
//    public ArrayList<Payment> getAllPayments() {
//        return this.payments;
//    }
//
//    @Override
//    public Payment create(Payment payment) {
//        this.payments.add(payment);
//        for(Payment paymentA : payments){
//            if(payment.equals(paymentA)){
//                return paymentA;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Payment update(Payment payment) {
//        return null; //Cannot update payment
//    }
//
//    @Override
//    public void delete(String customerId) {
//        for(Payment paymentA : payments){
//            if(customerId.equals(paymentA.getCustomer().getIdNumber())){
//                this.payments.remove(paymentA);
//                break;
//            }
//        }
//    }
//
//    @Override
//    public Payment read(String customerId) {
//        for(Payment paymentA : payments){
//            if(customerId.equals(paymentA.getCustomer().getIdNumber())){
//                return paymentA;
//            }
//        }
//        return null;
//    }
//}
