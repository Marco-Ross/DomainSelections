package com.marco.domain.bookings;

public class Refund {
    private double refundAmount;
    private int customerIdNumber;

    private Refund() {
    }

    private Refund(Builder builder){
        this.refundAmount = builder.refundAmount;
        this.customerIdNumber = builder.customerIdNumber;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public int getCustomerIdNumber() {
        return customerIdNumber;
    }

    public static class Builder{
        private double refundAmount;
        private int customerIdNumber;

        public Builder refundAmount(double refundAmount){
            this.refundAmount = refundAmount;
            return this;
        }

        public Builder customerIdNumber(int customerIdNumber){
            this.customerIdNumber = customerIdNumber;
            return this;
        }

        public Refund build(){return new Refund(this);}
    }
}
