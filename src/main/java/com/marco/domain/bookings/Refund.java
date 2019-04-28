package com.marco.domain.bookings;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;

public class Refund {
    private double refundAmount;

    private Refund() {
    }

    private Refund(Builder builder){
        this.refundAmount = builder.refundAmount;
    }

    public double getRefundAmount() {
        return refundAmount;
    }


    public static class Builder{
        private double refundAmount;

        public Builder refundAmount(double refundAmount){
            this.refundAmount = refundAmount;
            return this;
        }

        public Refund build(){return new Refund(this);}
    }
}
