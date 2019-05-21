package com.marco.factory.bookings;

import com.marco.domain.bookings.OfflineBooking;

import java.util.Date;

public class OfflineBookingFactory {
    public static OfflineBooking buildOfflineBooking(Date offlineBookingDate, int offlineQuantityBooked){
        return new OfflineBooking.Builder().offlineBookingDate(offlineBookingDate)
                .offlineQuantityBooked(offlineQuantityBooked)
                .build();
    }
}
