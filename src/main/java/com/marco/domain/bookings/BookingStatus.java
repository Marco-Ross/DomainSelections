package com.marco.domain.bookings;

import java.util.Date;

public class BookingStatus {
    private int bookingId;
    private Date timesBooked;

    private BookingStatus(){}

    private BookingStatus(Builder builder){
        this.bookingId = builder.bookingId;
        this.timesBooked = builder.timesBooked;
    }

    public int getBookingId(){
        return bookingId;
    }

    public Date getTimesBooked() {
        return timesBooked;
    }

    public static class Builder{
        private int bookingId;
        private Date timesBooked;

        public Builder bookingId(int bookingId){
            this.bookingId = bookingId;
            return this;
        }

        public Builder timesBooked(Date timesBooked){
            this.timesBooked = timesBooked;
            return this;
        }

        public BookingStatus build(){return new BookingStatus(this);}
    }
}
