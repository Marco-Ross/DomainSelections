package com.marco.domain.bookings;

public class OnlineBooking {
    private int carriageBooked;

    private OnlineBooking() {
    }

    private OnlineBooking(Builder builder){
        this.carriageBooked = builder.carriageBooked;
    }

    public int getCarriageBooked() {
        return carriageBooked;
    }

    public static class Builder{
        private int carriageBooked;

        public Builder carriageBooked(int carriageBooked){
            this.carriageBooked = carriageBooked;
            return this;
        }

        public OnlineBooking build(){return new OnlineBooking(this);}
    }
}
