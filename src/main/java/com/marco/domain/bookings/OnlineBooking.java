package com.marco.domain.bookings;

import java.util.Date;

public class OnlineBooking {
    private int onlineBookingId;
    private Date onlineBookingDate;
    private int carriageBooked;

    private OnlineBooking() {
    }

    private OnlineBooking(Builder builder){
        this.onlineBookingId = builder.onlineBookingId;
        this.onlineBookingDate = builder.onlineBookingDate;
        this.carriageBooked = builder.carriageBooked;
    }

    public int getOnlineBookingId() {
        return onlineBookingId;
    }

    public Date getOnlineBookingDate() {
        return onlineBookingDate;
    }

    public int getCarriageBooked() {
        return carriageBooked;
    }

    public static class Builder{
        private int onlineBookingId;
        private Date onlineBookingDate;
        private int carriageBooked;

        public Builder onlineBookingId(int onlineBookingId){
            this.onlineBookingId = onlineBookingId;
            return this;
        }

        public Builder onlineBookingDate(Date onlineBookingDate){
            this.onlineBookingDate = onlineBookingDate;
            return this;
        }

        public Builder carriageBooked(int carriageBooked){
            this.carriageBooked = carriageBooked;
            return this;
        }

        public OnlineBooking build(){return new OnlineBooking(this);}
    }
}
