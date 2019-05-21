package com.marco.factory.bookings;

import com.marco.domain.bookings.OnlineBooking;

import java.util.Date;

public class OnlineBookingFactory {
    public static OnlineBooking buildOnlineBooking(int onlineBookingId, Date onlineBookingDate, int carriageBooked){
        return new OnlineBooking.Builder().onlineBookingId(onlineBookingId)
                .onlineBookingDate(onlineBookingDate)
                .carriageBooked(carriageBooked)
                .build();
    }
}
