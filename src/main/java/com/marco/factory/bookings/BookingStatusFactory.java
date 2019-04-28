package com.marco.factory.bookings;

import com.marco.domain.bookings.BookingStatus;

import java.util.Date;

public class BookingStatusFactory {
    public static BookingStatus getBookingStatus(int bookingId,Date timesBooked){
        return new BookingStatus.Builder().bookingId(bookingId)
                .timesBooked(timesBooked)
                .build();
    }
}
