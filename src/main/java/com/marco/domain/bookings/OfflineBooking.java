package com.marco.domain.bookings;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class OfflineBooking implements Booking{
    @Id
    private int offlineBookingID;
    @Temporal(TemporalType.TIMESTAMP)
    private Date offlineBookingDate;
    private int offlineQuantityBooked;

    private OfflineBooking() {
    }

    private OfflineBooking(Builder builder){
        this.offlineBookingID = builder.offlineBookingID;
        this.offlineBookingDate = builder.offlineBookingDate;
        this.offlineQuantityBooked = builder.offlineQuantityBooked;
    }

    public int getOfflineBookingID() {
        return offlineBookingID;
    }

    public Date getOfflineBookingDate() {
        return offlineBookingDate;
    }

    public int getOfflineQuantityBooked() {
        return offlineQuantityBooked;
    }

    public static class Builder{
        private int offlineBookingID;
        private Date offlineBookingDate;
        private int offlineQuantityBooked;

        public Builder offlineBookingID(int offlineBookingID){
            this.offlineBookingID = offlineBookingID;
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

        public Builder copy(OfflineBooking offlineBooking){
            this.offlineBookingID = offlineBooking.offlineBookingID;
            this.offlineBookingDate = offlineBooking.offlineBookingDate;
            this.offlineQuantityBooked = offlineBooking.offlineQuantityBooked;

            return this;
        }

        public OfflineBooking build(){return new OfflineBooking(this);}
    }
}
