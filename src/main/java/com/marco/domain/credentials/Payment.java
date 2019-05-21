package com.marco.domain.credentials;

import com.marco.domain.actors.Customer;

public class Payment {
    private double amount;
    private Customer customer;

    private Payment() {
    }

    private Payment(Builder builder){
        this.amount = builder.amount;
        this.customer = builder.customer;
    }

    public double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static class Builder{
        private double amount;
        private Customer customer;

        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Builder copy(Payment payment){
            this.amount = payment.amount;
            this.customer = payment.customer;

            return this;
        }

        public Payment build(){return new Payment(this);}
    }
}
