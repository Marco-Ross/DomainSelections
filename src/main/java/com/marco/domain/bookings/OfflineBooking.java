package com.marco.domain.bookings;

public class OfflineBooking {
    private int offlineQuantityBooked;

    private OfflineBooking() {
    }

    private OfflineBooking(Builder builder){
        this.offlineQuantityBooked = builder.offlineQuantityBooked;
    }

    public int getOfflineQuantityBooked() {
        return offlineQuantityBooked;
    }

    public static class Builder{
        private int offlineQuantityBooked;

        public Builder offlineQuantityBooked(int offlineQuantityBooked){
            this.offlineQuantityBooked = offlineQuantityBooked;
            return this;
        }

        public OfflineBooking build(){return new OfflineBooking(this);}
    }
}
