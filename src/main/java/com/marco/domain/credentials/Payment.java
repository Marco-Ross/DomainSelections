package com.marco.domain.credentials;

import com.marco.domain.actors.Customer;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Payment {
    @Id
    private int paymentID;
    private double amount;
    private String idNumber;

    private Payment() {
    }

    private Payment(Builder builder){
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.idNumber = builder.idNumber;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return idNumber;
    }

    public static class Builder{
        private int paymentID;
        private double amount;
        private String idNumber;

        public Builder paymentID(int paymentID){
            this.paymentID = paymentID;
            return this;
        }

        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Builder idNumber(String idNumber){
            this.idNumber = idNumber;
            return this;
        }

        public Builder copy(Payment payment){
            this.paymentID = payment.paymentID;
            this.amount = payment.amount;
            this.idNumber = payment.idNumber;

            return this;
        }

        public Payment build(){return new Payment(this);}
    }
}
