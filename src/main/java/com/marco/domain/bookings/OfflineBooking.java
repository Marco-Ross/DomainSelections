package com.marco.domain.bookings;

import java.util.Date;

public class OfflineBooking {
    private int offlineBookingId;
    private Date offlineBookingDate;
    private int offlineQuantityBooked;

    private OfflineBooking() {
    }

    private OfflineBooking(Builder builder){
        this.offlineBookingId = builder.offlineBookingId;
        this.offlineBookingDate = builder.offlineBookingDate;
        this.offlineQuantityBooked = builder.offlineQuantityBooked;
    }

    public int getOfflineBookingId() {
        return offlineBookingId;
    }

    public Date getOfflineBookingDate() {
        return offlineBookingDate;
    }

    public int getOfflineQuantityBooked() {
        return offlineQuantityBooked;
    }

    public static class Builder{
        private int offlineBookingId;
        private Date offlineBookingDate;
        private int offlineQuantityBooked;

        public Builder offlineBookingId(int offlineBookingId){
            this.offlineBookingId = offlineBookingId;
            return this;
        }

        public Builder offlineBookingDate(Date offlineBookingDate){
            this.offlineBookingDate = offlineBookingDate;
            return this;
        }

        public Builder offlineQuantityBooked(int offlineQuantityBooked){
            this.offlineQuantityBooked = offlineQuantityBooked;
            return this;
        }

        public OfflineBooking build(){return new OfflineBooking(this);}
    }
}
