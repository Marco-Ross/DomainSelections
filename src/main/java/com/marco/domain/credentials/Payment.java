package com.marco.domain.credentials;

public class Payment {
    private double amount;

    private Payment() {
    }

    private Payment(Builder builder){
        this.amount = builder.amount;
    }

    public double getAmount() {
        return amount;
    }

    public static class Builder{
        private double amount;

        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Payment build(){return new Payment(this);}
    }
}
