package com.marco.factory.bookings;

import com.marco.domain.bookings.BookingStatus;

import java.util.Date;

public class BookingStatusFactory {
    public static BookingStatus getBookingStatus(Date timesBooked){
        return new BookingStatus.Builder().timesBooked(timesBooked)
                .build();
    }
}
