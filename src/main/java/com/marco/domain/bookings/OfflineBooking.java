package com.marco.domain.bookings;

import java.util.Date;

public class OfflineBooking implements Booking{
    private Date offlineBookingDate;
    private int offlineQuantityBooked;

    private OfflineBooking() {
    }

    private OfflineBooking(Builder builder){
        this.offlineBookingDate = builder.offlineBookingDate;
        this.offlineQuantityBooked = builder.offlineQuantityBooked;
    }

    public Date getOfflineBookingDate() {
        return offlineBookingDate;
    }

    public int getOfflineQuantityBooked() {
        return offlineQuantityBooked;
    }

    public static class Builder{
        private Date offlineBookingDate;
        private int offlineQuantityBooked;

        public Builder offlineBookingDate(Date offlineBookingDate){
            this.offlineBookingDate = offlineBookingDate;
            return this;
        }

        public Builder offlineQuantityBooked(int offlineQuantityBooked){
            this.offlineQuantityBooked = offlineQuantityBooked;
            return this;
        }

        public Builder copy(OfflineBooking offlineBooking){
            this.offlineBookingDate = offlineBooking.offlineBookingDate;
            this.offlineQuantityBooked = offlineBooking.offlineQuantityBooked;

            return this;
        }

        public OfflineBooking build(){return new OfflineBooking(this);}
    }
}
