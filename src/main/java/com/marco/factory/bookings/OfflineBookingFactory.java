package com.marco.factory.bookings;

import com.marco.domain.bookings.OfflineBooking;

import java.util.Date;

public class OfflineBookingFactory {
    public static OfflineBooking getOfflineBooking(int offlineBookingId, Date offlineBookingDate, int offlineQuantityBooked){
        return new OfflineBooking.Builder().offlineBookingId(offlineBookingId)
                .offlineBookingDate(offlineBookingDate)
                .offlineQuantityBooked(offlineQuantityBooked)
                .build();
    }
}
