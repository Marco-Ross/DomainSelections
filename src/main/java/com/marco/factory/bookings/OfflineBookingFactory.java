package com.marco.factory.bookings;

import com.marco.domain.bookings.OfflineBooking;

public class OfflineBookingFactory {
    public static OfflineBooking getOfflineBooking(int offlineQuantityBooked){
        return new OfflineBooking.Builder().offlineQuantityBooked(offlineQuantityBooked)
                .build();
    }
}
