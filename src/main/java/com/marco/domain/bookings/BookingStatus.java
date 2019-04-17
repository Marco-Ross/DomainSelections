package com.marco.domain.bookings;

import java.util.Date;

public class BookingStatus {
    private Date timesBooked;

    private BookingStatus(){}

    private BookingStatus(Builder builder){
        this.timesBooked = builder.timesBooked;
    }

    public Date getTimesBooked() {
        return timesBooked;
    }

    public static class Builder{
        private Date timesBooked;

        public Builder timesBooked(Date timesBooked){
            this.timesBooked = timesBooked;
            return this;
        }

        public BookingStatus build(){return new BookingStatus(this);}
    }
}
